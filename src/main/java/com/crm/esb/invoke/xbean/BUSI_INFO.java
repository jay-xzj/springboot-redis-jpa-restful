/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id$
 */

package com.crm.esb.invoke.xbean;

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


      //----------------/
     //- Constructors -/
    //----------------/

    public BUSI_INFO() {
        super();
    } //-- esbInvoke.xbean.BUSI_INFO()


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
     * 
     * 
     * @param reader
    **/
    public static com.crm.esb.invoke.xbean.BUSI_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.esb.invoke.xbean.BUSI_INFO) Unmarshaller.unmarshal(com.crm.esb.invoke.xbean.BUSI_INFO.class, reader);
    } //-- esbInvoke.xbean.BUSI_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
