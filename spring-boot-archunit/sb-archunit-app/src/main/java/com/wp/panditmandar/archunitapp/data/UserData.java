package com.wp.panditmandar.archunitapp.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface UserData extends JpaRepository<User, Long> {

}
