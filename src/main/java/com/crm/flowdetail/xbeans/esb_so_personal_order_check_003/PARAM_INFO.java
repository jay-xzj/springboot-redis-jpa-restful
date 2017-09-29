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
public class PARAM_INFO implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _KEY;

    private java.lang.String _VALUE;


      //----------------/
     //- Constructors -/
    //----------------/

    public PARAM_INFO() {
        super();
    } //-- com.asiainfo.aiccsp2.common.wsclient.crmesb.xbeans.esb_so_personal_order_check_003.request.PARAM_INFO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'KEY'.
     * 
     * @return the value of field 'KEY'.
    **/
    public java.lang.String getKEY()
    {
        return this._KEY;
    } //-- java.lang.String getKEY() 

    /**
     * Returns the value of field 'VALUE'.
     * 
     * @return the value of field 'VALUE'.
    **/
    public java.lang.String getVALUE()
    {
        return this._VALUE;
    } //-- java.lang.String getVALUE() 

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
     * Sets the value of field 'KEY'.
     * 
     * @param KEY the value of field 'KEY'.
    **/
    public void setKEY(java.lang.String KEY)
    {
        this._KEY = KEY;
    } //-- void setKEY(java.lang.String) 

    /**
     * Sets the value of field 'VALUE'.
     * 
     * @param VALUE the value of field 'VALUE'.
    **/
    public void setVALUE(java.lang.String VALUE)
    {
        this._VALUE = VALUE;
    } //-- void setVALUE(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/
    public static com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO) Unmarshaller.unmarshal(com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_INFO.class, reader);
    } //-- com.asiainfo.aiccsp2.common.wsclient.crmesb.xbeans.esb_so_personal_order_check_003.request.PARAM_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
