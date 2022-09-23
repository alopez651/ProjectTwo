package com.revature.project.DTO;

import com.revature.project.Entity.Product;
import com.revature.project.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserProductDto {
    User users;
    Product product;

}
