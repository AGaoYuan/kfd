package cn.kfd.model;
import java.util.Date;

/**
 * smbms_role entity
 * @author Happy
 * @date2018-11-02 08:22
 */

public class SmbmsRole{
  /**主键ID**/
 private Long id;
  /**角色编码**/
 private String roleCode;
  /**角色名称**/
 private String roleName;
  /**创建者**/
 private Long createdBy;
  /**创建时间**/
 private Date creationDate;
  /**修改者**/
 private Long modifyBy;
  /**修改时间**/
 private Date modifyDate;

 public void setId(Long id){
     this.id=id;
 }

 public Long getId(){
     return id;
 }

 public void setRoleCode(String roleCode){
     this.roleCode=roleCode;
 }

 public String getRoleCode(){
     return roleCode;
 }

 public void setRoleName(String roleName){
     this.roleName=roleName;
 }

 public String getRoleName(){
     return roleName;
 }

 public void setCreatedBy(Long createdBy){
     this.createdBy=createdBy;
 }

 public Long getCreatedBy(){
     return createdBy;
 }

 public void setCreationDate(Date creationDate){
     this.creationDate=creationDate;
 }

 public Date getCreationDate(){
     return creationDate;
 }

 public void setModifyBy(Long modifyBy){
     this.modifyBy=modifyBy;
 }

 public Long getModifyBy(){
     return modifyBy;
 }

 public void setModifyDate(Date modifyDate){
     this.modifyDate=modifyDate;
 }

 public Date getModifyDate(){
     return modifyDate;
 }
}

