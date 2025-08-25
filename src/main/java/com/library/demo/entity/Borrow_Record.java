package com.library.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "borrow_record")
public class Borrow_Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "book_id")
    private Long book_id;
    @Column(name = "reader_id")
    private Long reader_id;
    @Column(name = "borrow_date")
    private String borrow_date;
    @Column(name = "return_date")
    private String return_date;

    


    

}
