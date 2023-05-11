package com.bbtutorials.users.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Users {

  @Id
  @Column
  private long id;

  @Column
  @NotNull(message = "{NotNull.User.firstName}")
  private String firstName;

  @Column
  @NotNull(message = "{NotNull.User.lastName}")
  private String lastName;

  @Column
  @NotNull(message = "{NotNull.User.email}")
  private String email;

  @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "poster")
  private List<Post> posts;

}
