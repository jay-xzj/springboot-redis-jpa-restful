/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001;

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

    private java.lang.String _START_DATE;

    private java.lang.String _END_DATE;

    private java.lang.String _TOP_AMOUNT;


      //----------------/
     //- Constructors -/
    //----------------/

    public BUSI_INFO() {
        super();
    } //-- com.asiainfo.scrm.module.res.flowdetail.xbeans.esb_cs_qry_free_detail_004.BUSI_INFO()


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
     * Returns the value of field 'END_DATE'.
     * 
     * @return the value of field 'END_DATE'.
    **/
    public java.lang.String getEND_DATE()
    {
        return this._END_DATE;
    } //-- java.lang.String getEND_DATE() 

    /**
     * Returns the value of field 'START_DATE'.
     * 
     * @return the value of field 'START_DATE'.
    **/
    public java.lang.String getSTART_DATE()
    {
        return this._START_DATE;
    } //-- java.lang.String getSTART_DATE() 

    /**
     * Returns the value of field 'TOP_AMOUNT'.
     * 
     * @return the value of field 'TOP_AMOUNT'.
    **/
    public java.lang.String getTOP_AMOUNT()
    {
        return this._TOP_AMOUNT;
    } //-- java.lang.String getTOP_AMOUNT() 

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
     * Sets the value of field 'END_DATE'.
     * 
     * @param END_DATE the value of field 'END_DATE'.
    **/
    public void setEND_DATE(java.lang.String END_DATE)
    {
        this._END_DATE = END_DATE;
    } //-- void setEND_DATE(java.lang.String) 

    /**
     * Sets the value of field 'START_DATE'.
     * 
     * @param START_DATE the value of field 'START_DATE'.
    **/
    public void setSTART_DATE(java.lang.String START_DATE)
    {
        this._START_DATE = START_DATE;
    } //-- void setSTART_DATE(java.lang.String) 

    /**
     * Sets the value of field 'TOP_AMOUNT'.
     * 
     * @param TOP_AMOUNT the value of field 'TOP_AMOUNT'.
    **/
    public void setTOP_AMOUNT(java.lang.String TOP_AMOUNT)
    {
        this._TOP_AMOUNT = TOP_AMOUNT;
    } //-- void setTOP_AMOUNT(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/
    public static com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO) Unmarshaller.unmarshal(com.crm.flowdetail.xbeans.esb_cs_qry_record_topn_001.BUSI_INFO.class, reader);
    } //-- com.asiainfo.scrm.module.res.flowdetail.xbeans.esb_cs_qry_free_detail_004.BUSI_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
