package org.example.javacore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private Long id;
    private String name;
    private String phoneNumber;
    private String address;

    @Override
    public int compareTo(Student otherStudent) {
        if (otherStudent != null) {
            // Compare by name
            return this.name.compareTo(otherStudent.getName());
        }
        throw new IllegalArgumentException("Object is not an instance of Student");
    }
}
