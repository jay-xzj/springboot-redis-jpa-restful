/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id: BUSI_INFO.java 112 2015-02-10 11:13:29Z wanglf $
 */

package com.crm.flowdetail.xbeans.esb_cs_qry_used_freeres_001;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * 
 * 
 * @version $Revision: 112 $ $Date: 2015-02-10 19:13:29 +0800 (周二, 10 二月 2015) $
**/
public class BUSI_INFO implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _BILL_ID;

    private java.lang.String _RELAT_TYPE;

    private java.lang.String _QUERY_MONTH;


      //----------------/
     //- Constructors -/
    //----------------/

    public BUSI_INFO() {
        super();
    } //-- com.asiainfo.scrm.module.customer.query.xbeans.qryusedfreeres001.req.BUSI_INFO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'BILL_ID'.
     * 
     * @return the value of field 'BILL_ID'.
    **/
    public java.lang.String getBILL_ID()
    {
        return this._BILL_ID;
    } //-- java.lang.String getBILL_ID() 

    /**
     * Returns the value of field 'QUERY_MONTH'.
     * 
     * @return the value of field 'QUERY_MONTH'.
    **/
    public java.lang.String getQUERY_MONTH()
    {
        return this._QUERY_MONTH;
    } //-- java.lang.String getQUERY_MONTH() 

    /**
     * Returns the value of field 'RELAT_TYPE'.
     * 
     * @return the value of field 'RELAT_TYPE'.
    **/
    public java.lang.String getRELAT_TYPE()
    {
        return this._RELAT_TYPE;
    } //-- java.lang.String getRELAT_TYPE() 

    /**
    **/
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * 
     * 
     * @param out
    **/
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * 
     * 
     * @param handler
    **/
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'BILL_ID'.
     * 
     * @param BILL_ID the value of field 'BILL_ID'.
    **/
    public void setBILL_ID(java.lang.String BILL_ID)
    {
        this._BILL_ID = BILL_ID;
    } //-- void setBILL_ID(java.lang.String) 

    /**
     * Sets the value of field 'QUERY_MONTH'.
     * 
     * @param QUERY_MONTH the value of field 'QUERY_MONTH'.
    **/
    public void setQUERY_MONTH(java.lang.String QUERY_MONTH)
    {
        this._QUERY_MONTH = QUERY_MONTH;
    } //-- void setQUERY_MONTH(java.lang.String) 

    /**
     * Sets the value of field 'RELAT_TYPE'.
     * 
     * @param RELAT_TYPE the value of field 'RELAT_TYPE'.
    **/
    public void setRELAT_TYPE(java.lang.String RELAT_TYPE)
    {
        this._RELAT_TYPE = RELAT_TYPE;
    } //-- void setRELAT_TYPE(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/
    public static com.crm.flowdetail.xbeans.esb_cs_qry_used_freeres_001.BUSI_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.flowdetail.xbeans.esb_cs_qry_used_freeres_001.BUSI_INFO) Unmarshaller.unmarshal(com.crm.flowdetail.xbeans.esb_cs_qry_used_freeres_001.BUSI_INFO.class, reader);
    } //-- com.asiainfo.scrm.module.customer.query.xbeans.qryusedfreeres001.req.BUSI_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
