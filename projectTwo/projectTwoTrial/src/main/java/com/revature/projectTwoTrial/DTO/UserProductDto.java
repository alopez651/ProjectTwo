package com.revature.projectTwoTrial.DTO;

import com.revature.projectTwoTrial.Entity.Product;
import com.revature.projectTwoTrial.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserProductDto {
    User users;
    Product cart;

}
