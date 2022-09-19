package com.revature.projectTwoTrial.DTO;

import com.revature.projectTwoTrial.Entity.CartEntity;
import com.revature.projectTwoTrial.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserCartDto {
    UserEntity users;
    CartEntity cart;

}
