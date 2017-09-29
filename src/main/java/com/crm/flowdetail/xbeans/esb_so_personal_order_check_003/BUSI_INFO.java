/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.crm.flowdetail.xbeans.esb_so_personal_order_check_003;

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

    private java.lang.String _CHECK_TYPE;

    private java.lang.String _CHECK_ID;

    private PARAM_LIST _PARAM_LIST;


      //----------------/
     //- Constructors -/
    //----------------/

    public BUSI_INFO() {
        super();
    } //-- com.asiainfo.aiccsp2.common.wsclient.crmesb.xbeans.esb_so_personal_order_check_003.request.BUSI_INFO()


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
     * Returns the value of field 'CHECK_ID'.
     * 
     * @return the value of field 'CHECK_ID'.
    **/
    public java.lang.String getCHECK_ID()
    {
        return this._CHECK_ID;
    } //-- java.lang.String getCHECK_ID() 

    /**
     * Returns the value of field 'CHECK_TYPE'.
     * 
     * @return the value of field 'CHECK_TYPE'.
    **/
    public java.lang.String getCHECK_TYPE()
    {
        return this._CHECK_TYPE;
    } //-- java.lang.String getCHECK_TYPE() 

    /**
     * Returns the value of field 'PARAM_LIST'.
     * 
     * @return the value of field 'PARAM_LIST'.
    **/
    public PARAM_LIST getPARAM_LIST()
    {
        return this._PARAM_LIST;
    } //-- PARAM_LIST getPARAM_LIST() 

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
     * Sets the value of field 'CHECK_ID'.
     * 
     * @param CHECK_ID the value of field 'CHECK_ID'.
    **/
    public void setCHECK_ID(java.lang.String CHECK_ID)
    {
        this._CHECK_ID = CHECK_ID;
    } //-- void setCHECK_ID(java.lang.String) 

    /**
     * Sets the value of field 'CHECK_TYPE'.
     * 
     * @param CHECK_TYPE the value of field 'CHECK_TYPE'.
    **/
    public void setCHECK_TYPE(java.lang.String CHECK_TYPE)
    {
        this._CHECK_TYPE = CHECK_TYPE;
    } //-- void setCHECK_TYPE(java.lang.String) 

    /**
     * Sets the value of field 'PARAM_LIST'.
     * 
     * @param PARAM_LIST the value of field 'PARAM_LIST'.
    **/
    public void setPARAM_LIST(PARAM_LIST PARAM_LIST)
    {
        this._PARAM_LIST = PARAM_LIST;
    } //-- void setPARAM_LIST(PARAM_LIST) 

    /**
     * 
     * 
     * @param reader
    **/
    public static com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.BUSI_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.BUSI_INFO) Unmarshaller.unmarshal(com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.BUSI_INFO.class, reader);
    } //-- com.asiainfo.scrm.module.rboss.flowshare.xbeans.esb_so_personal_order_check_003.request.BUSI_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
