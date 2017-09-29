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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.*;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * 
 * 
 * @version $Revision$ $Date$
**/
public class PARAM_LIST implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.util.Vector _PARAM_INFOList;


      //----------------/
     //- Constructors -/
    //----------------/

    public PARAM_LIST() {
        super();
        _PARAM_INFOList = new Vector();
    } //-- com.asiainfo.aiccsp2.common.wsclient.crmesb.xbeans.esb_so_personal_order_check_003.request.PARAM_LIST()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * 
     * 
     * @param vPARAM_INFO
    **/
    public void addPARAM_INFO(PARAM_INFO vPARAM_INFO)
        throws java.lang.IndexOutOfBoundsException
    {
        _PARAM_INFOList.addElement(vPARAM_INFO);
    } //-- void addPARAM_INFO(PARAM_INFO) 

    /**
     * 
     * 
     * @param index
     * @param vPARAM_INFO
    **/
    public void addPARAM_INFO(int index, PARAM_INFO vPARAM_INFO)
        throws java.lang.IndexOutOfBoundsException
    {
        _PARAM_INFOList.insertElementAt(vPARAM_INFO, index);
    } //-- void addPARAM_INFO(int, PARAM_INFO) 

    /**
    **/
    public java.util.Enumeration enumeratePARAM_INFO()
    {
        return _PARAM_INFOList.elements();
    } //-- java.util.Enumeration enumeratePARAM_INFO() 

    /**
     * 
     * 
     * @param index
    **/
    public PARAM_INFO getPARAM_INFO(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _PARAM_INFOList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (PARAM_INFO) _PARAM_INFOList.elementAt(index);
    } //-- PARAM_INFO getPARAM_INFO(int) 

    /**
    **/
    public PARAM_INFO[] getPARAM_INFO()
    {
        int size = _PARAM_INFOList.size();
        PARAM_INFO[] mArray = new PARAM_INFO[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (PARAM_INFO) _PARAM_INFOList.elementAt(index);
        }
        return mArray;
    } //-- PARAM_INFO[] getPARAM_INFO() 

    /**
    **/
    public int getPARAM_INFOCount()
    {
        return _PARAM_INFOList.size();
    } //-- int getPARAM_INFOCount() 

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
    **/
    public void removeAllPARAM_INFO()
    {
        _PARAM_INFOList.removeAllElements();
    } //-- void removeAllPARAM_INFO() 

    /**
     * 
     * 
     * @param index
    **/
    public PARAM_INFO removePARAM_INFO(int index)
    {
        java.lang.Object obj = _PARAM_INFOList.elementAt(index);
        _PARAM_INFOList.removeElementAt(index);
        return (PARAM_INFO) obj;
    } //-- PARAM_INFO removePARAM_INFO(int) 

    /**
     * 
     * 
     * @param index
     * @param vPARAM_INFO
    **/
    public void setPARAM_INFO(int index, PARAM_INFO vPARAM_INFO)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _PARAM_INFOList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _PARAM_INFOList.setElementAt(vPARAM_INFO, index);
    } //-- void setPARAM_INFO(int, PARAM_INFO) 

    /**
     * 
     * 
     * @param PARAM_INFOArray
    **/
    public void setPARAM_INFO(PARAM_INFO[] PARAM_INFOArray)
    {
        //-- copy array
        _PARAM_INFOList.removeAllElements();
        for (int i = 0; i < PARAM_INFOArray.length; i++) {
            _PARAM_INFOList.addElement(PARAM_INFOArray[i]);
        }
    } //-- void setPARAM_INFO(PARAM_INFO) 

    /**
     * 
     * 
     * @param reader
    **/
    public static com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_LIST unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_LIST) Unmarshaller.unmarshal(com.crm.flowdetail.xbeans.esb_so_personal_order_check_003.PARAM_LIST.class, reader);
    } //-- com.asiainfo.scrm.module.rboss.flowshare.xbeans.esb_so_personal_order_check_003.request.PARAM_LIST unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
