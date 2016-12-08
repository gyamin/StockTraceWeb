package com.gyamin.stocktrace.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = IssuesListener.class)
@Table(name = "issues")
public class Issues {

    /** */
    @Id
    @Column(name = "section")
    String section;

    /** */
    @Id
    @Column(name = "issue_code")
    Integer issueCode;

    /** */
    @Column(name = "issue_name")
    String issueName;

    /** */
    @Column(name = "sector_code33")
    Integer sectorCode33;

    /** */
    @Column(name = "sector_code17")
    Integer sectorCode17;

    /** */
    @Column(name = "size_code")
    String sizeCode;

    /** 
     * Returns the section.
     * 
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /** 
     * Sets the section.
     * 
     * @param section the section
     */
    public void setSection(String section) {
        this.section = section;
    }

    /** 
     * Returns the issueCode.
     * 
     * @return the issueCode
     */
    public Integer getIssueCode() {
        return issueCode;
    }

    /** 
     * Sets the issueCode.
     * 
     * @param issueCode the issueCode
     */
    public void setIssueCode(Integer issueCode) {
        this.issueCode = issueCode;
    }

    /** 
     * Returns the issueName.
     * 
     * @return the issueName
     */
    public String getIssueName() {
        return issueName;
    }

    /** 
     * Sets the issueName.
     * 
     * @param issueName the issueName
     */
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    /** 
     * Returns the sectorCode33.
     * 
     * @return the sectorCode33
     */
    public Integer getSectorCode33() {
        return sectorCode33;
    }

    /** 
     * Sets the sectorCode33.
     * 
     * @param sectorCode33 the sectorCode33
     */
    public void setSectorCode33(Integer sectorCode33) {
        this.sectorCode33 = sectorCode33;
    }

    /** 
     * Returns the sectorCode17.
     * 
     * @return the sectorCode17
     */
    public Integer getSectorCode17() {
        return sectorCode17;
    }

    /** 
     * Sets the sectorCode17.
     * 
     * @param sectorCode17 the sectorCode17
     */
    public void setSectorCode17(Integer sectorCode17) {
        this.sectorCode17 = sectorCode17;
    }

    /** 
     * Returns the sizeCode.
     * 
     * @return the sizeCode
     */
    public String getSizeCode() {
        return sizeCode;
    }

    /** 
     * Sets the sizeCode.
     * 
     * @param sizeCode the sizeCode
     */
    public void setSizeCode(String sizeCode) {
        this.sizeCode = sizeCode;
    }
}