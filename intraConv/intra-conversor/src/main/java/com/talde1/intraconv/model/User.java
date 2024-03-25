package com.talde1.intraconv.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "res_users")
@XmlAccessorType(XmlAccessType.FIELD)
@DynamicUpdate
public class User {

    /*@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;*/

    /*private int company_id, partner_id, action_id, create_uid, write_uid, sale_team_id, karma, rank_id, next_rank_id, target_sales_won,
                target_sales_done, target_sales_invoiced, website_id, last_lunch_location_id;

    private boolean active, share, odoobot_failed;

    private Timestamp create_date, write_date;

    private String login, password, signature, totp_secret, notification_type, odoobot_state, livechat_username;*/

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String userName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="notification_type")
    private String notification_type = "none";
    
    //Foreign keys
    @Column(name = "company_id")
    private Integer company_id = 1;
    
    @Column(name = "create_uid")
    private Integer create_uid = 1;

    
    @Column(name = "last_lunch_location_id")
    @XmlElement(nillable = true)
    private Integer last_lunch_location_id = 1;
    
    @Column(name = "next_rank_id")
    private Integer next_rank_id = 1;
    
    @Column(name = "partner_id")
    private Integer partner_id = 1;
    
    @Column(name = "rank_id")
    private Integer rank_id = 1;
    
    @Column(name = "sale_team_id")
    private Integer sale_team_id = 1;
    
    @Column(name = "website_id")
    private Integer website_id = 1;
    
    @Column(name = "write_uid")
    private Integer write_uid = 1; 

    

    public User() {

    }
    
    public User(int id, String userName, String phone, String email, String login) {
        this.id = id;
        this.userName = userName;
        this.phone = phone;
        this.email = email;
        this.login = login;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        if (this.userName != null) {
            return userName;
        }else{
            return "Null";
        }
    }
    public void setName(String name) {
        this.userName = name;
    }
    public String getPhone() {
        if (this.phone != null) {
            return phone;
        }else{
            return "Null";
        }
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        if (this.email != null) {
            return email;
        }else{
            return "Null";
        }
    }
    public void setEmail(String email) {
        this.email = email;
    }


    //Getters and setters for foreign keys
    

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + userName + ", phone=" + phone + ", email=" + email + "]";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getCreate_uid() {
        return create_uid;
    }

    public void setCreate_uid(int create_uid) {
        this.create_uid = create_uid;
    }

    public int getLast_lunch_location_id() {
        return last_lunch_location_id;
    }

    public void setLast_lunch_location_id(int last_lunch_location_id) {
        this.last_lunch_location_id = last_lunch_location_id;
    }

    public int getNext_rank_id() {
        return next_rank_id;
    }

    public void setNext_rank_id(int next_rank_id) {
        this.next_rank_id = next_rank_id;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public int getRank_id() {
        return rank_id;
    }

    public void setRank_id(int rank_id) {
        this.rank_id = rank_id;
    }

    public int getSale_team_id() {
        return sale_team_id;
    }

    public void setSale_team_id(int sale_team_id) {
        this.sale_team_id = sale_team_id;
    }

    public int getWebsite_id() {
        return website_id;
    }

    public void setWebsite_id(int website_id) {
        this.website_id = website_id;
    }

    public int getWrite_uid() {
        return write_uid;
    }

    public void setWrite_uid(int write_uid) {
        this.write_uid = write_uid;
    }

    public String getLogin() {
        if (this.login != null) {
            return login;
        }else{
            return "Null";
        }
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public void setCreate_uid(Integer create_uid) {
        this.create_uid = create_uid;
    }

    public void setNext_rank_id(Integer next_rank_id) {
        this.next_rank_id = next_rank_id;
    }

    public void setPartner_id(Integer partner_id) {
        this.partner_id = partner_id;
    }

    public void setRank_id(Integer rank_id) {
        this.rank_id = rank_id;
    }

    public void setSale_team_id(Integer sale_team_id) {
        this.sale_team_id = sale_team_id;
    }

    public void setWebsite_id(Integer website_id) {
        this.website_id = website_id;
    }

    public void setWrite_uid(Integer write_uid) {
        this.write_uid = write_uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }    
}
