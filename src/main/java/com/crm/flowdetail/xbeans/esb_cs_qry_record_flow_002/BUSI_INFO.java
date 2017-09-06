/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_002;

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
 * @version $Revision$ $Date$
**/
public class BUSI_INFO implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _BILL_ID;

    private java.lang.String _QUERY_DATE;

    private java.lang.String _APP_CODE;

    private java.lang.String _SUM_TYPE;


      //----------------/
     //- Constructors -/
    //----------------/

    public BUSI_INFO() {
        super();
    } //-- com.asiainfo.scrm.module.res.flowdetail.xbeans.ESB_CS_QRY_RECORD_FLOW_002.BUSI_INFO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'APP_CODE'.
     * 
     * @return the value of field 'APP_CODE'.
    **/
    public java.lang.String getAPP_CODE()
    {
        return this._APP_CODE;
    } //-- java.lang.String getAPP_CODE() 

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
     * Returns the value of field 'QUERY_DATE'.
     * 
     * @return the value of field 'QUERY_DATE'.
    **/
    public java.lang.String getQUERY_DATE()
    {
        return this._QUERY_DATE;
    } //-- java.lang.String getQUERY_DATE() 

    /**
     * Returns the value of field 'SUM_TYPE'.
     * 
     * @return the value of field 'SUM_TYPE'.
    **/
    public java.lang.String getSUM_TYPE()
    {
        return this._SUM_TYPE;
    } //-- java.lang.String getSUM_TYPE() 

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
     * Sets the value of field 'APP_CODE'.
     * 
     * @param APP_CODE the value of field 'APP_CODE'.
    **/
    public void setAPP_CODE(java.lang.String APP_CODE)
    {
        this._APP_CODE = APP_CODE;
    } //-- void setAPP_CODE(java.lang.String) 

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
     * Sets the value of field 'QUERY_DATE'.
     * 
     * @param QRY_DATE the value of field 'QUERY_DATE'.
    **/
    public void setQUERY_DATE(java.lang.String QUERY_DATE)
    {
        this._QUERY_DATE = QUERY_DATE;
    } //-- void setQUERY_DATE(java.lang.String) 

    /**
     * Sets the value of field 'SUM_TYPE'.
     * 
     * @param SUM_TYPE the value of field 'SUM_TYPE'.
    **/
    public void setSUM_TYPE(java.lang.String SUM_TYPE)
    {
        this._SUM_TYPE = SUM_TYPE;
    } //-- void setSUM_TYPE(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/
    public static com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_002.BUSI_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_002.BUSI_INFO) Unmarshaller.unmarshal(com.crm.flowdetail.xbeans.esb_cs_qry_record_flow_002.BUSI_INFO.class, reader);
    } //-- com.asiainfo.scrm.module.res.flowdetail.xbeans.ESB_CS_QRY_RECORD_FLOW_002.BUSI_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
