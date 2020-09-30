/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ookee
 */
public interface GeneralEntity extends Serializable{
    
    String getClassName();

    String getAtrValue();

    String setAtrValue();

    String getNameByColumn(int i);

    String getWhereCondition();
    
    String getSpecialCondition();
    
    String getForeignKeyCondition();
    
    GeneralEntity getNewRecord(ResultSet rs) throws SQLException;
    
}
