package com.hhb.app.entil;

import java.util.Date;

public class Book {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.id
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.bookName
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    private String bookname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.bookUser
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    private String bookuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book.publish
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    private Date publish;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.id
     *
     * @return the value of book.id
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.id
     *
     * @param id the value for book.id
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.bookName
     *
     * @return the value of book.bookName
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.bookName
     *
     * @param bookname the value for book.bookName
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.bookUser
     *
     * @return the value of book.bookUser
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public String getBookuser() {
        return bookuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.bookUser
     *
     * @param bookuser the value for book.bookUser
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public void setBookuser(String bookuser) {
        this.bookuser = bookuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book.publish
     *
     * @return the value of book.publish
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public Date getPublish() {
        return publish;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book.publish
     *
     * @param publish the value for book.publish
     *
     * @mbggenerated Fri Jan 29 11:22:28 CST 2016
     */
    public void setPublish(Date publish) {
        this.publish = publish;
    }
}