package com.dhu.ats.model;

import java.util.List;

public class Organization {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.org_id
     *
     * @mbg.generated
     */
    private Integer orgId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.org_name
     *
     * @mbg.generated
     */
    private String orgName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.left
     *
     * @mbg.generated
     */
    private Integer left;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.right
     *
     * @mbg.generated
     */
    private Integer right;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column organization.layer
     *
     * @mbg.generated
     */
    private Integer layer;

    private List<Organization> departments;

    private List<Organization> persons;

    public List<Organization> getPersons() {
        return persons;
    }

    public void setPersons(List<Organization> persons) {
        this.persons = persons;
    }

    public List<Organization> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Organization> departments) {
        this.departments = departments;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.org_id
     *
     * @return the value of organization.org_id
     *
     * @mbg.generated
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.org_id
     *
     * @param orgId the value for organization.org_id
     *
     * @mbg.generated
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.org_name
     *
     * @return the value of organization.org_name
     *
     * @mbg.generated
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.org_name
     *
     * @param orgName the value for organization.org_name
     *
     * @mbg.generated
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.left
     *
     * @return the value of organization.left
     *
     * @mbg.generated
     */
    public Integer getLeft() {
        return left;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.left
     *
     * @param left the value for organization.left
     *
     * @mbg.generated
     */
    public void setLeft(Integer left) {
        this.left = left;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.right
     *
     * @return the value of organization.right
     *
     * @mbg.generated
     */
    public Integer getRight() {
        return right;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.right
     *
     * @param right the value for organization.right
     *
     * @mbg.generated
     */
    public void setRight(Integer right) {
        this.right = right;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column organization.layer
     *
     * @return the value of organization.layer
     *
     * @mbg.generated
     */
    public Integer getLayer() {
        return layer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column organization.layer
     *
     * @param layer the value for organization.layer
     *
     * @mbg.generated
     */
    public void setLayer(Integer layer) {
        this.layer = layer;
    }
}