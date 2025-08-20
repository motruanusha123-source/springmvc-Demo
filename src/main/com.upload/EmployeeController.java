package com.upload;

import com.upload.dao.EmployeeDAO;
import com.upload.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller

public class EmployeeController {

    private final EmployeeDAO dao = new EmployeeDAO();

    @GetMapping("/form")
    public String showForm() {
        return "employeeForm";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("resume") MultipartFile resume,
                             HttpServletRequest request) throws Exception {

        String fileName = resume.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

        if (!(ext.equals("pdf") || ext.equals("xlsx") || ext.equals("xls"))) {
            throw new IllegalArgumentException("File type not supported!");
        }

        String uploadDir = "C:/employee_resumes/";
        File targetFile = new File(uploadDir + fileName);
        resume.transferTo(targetFile);

        Employee emp = new Employee();
        emp.setName(name);
        emp.setResumeName(fileName);
        emp.setResumePath(targetFile.getAbsolutePath());

        dao.saveEmployee(emp);

        return "redirect:/form";
    }
}
