/*
 * This class was automatically generated with 
 * <a href="http://castor.exolab.org">Castor 0.9.4</a>, using an
 * XML Schema.
 * $Id: PUB_INFO.java 112 2015-02-10 11:13:29Z wanglf $
 */

package esbInvoke.pojo;

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
public class PUB_INFO implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    private java.lang.String _SYS_OP_ID;

    private java.lang.String _SYS_PASSWORD;

    private java.lang.String _OP_ID;

    private java.lang.String _OP_ORG_ID;

    private java.lang.String _CLIENT_IP;

    private java.lang.String _MAC_ADDRESS;

    private java.lang.String _REQ_SERIAL_NO;

    private java.lang.String _MENU_ID;


      //----------------/
     //- Constructors -/
    //----------------/

    public PUB_INFO() {
        super();
    } //-- esbInvoke.pojo.PUB_INFO()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'CLIENT_IP'.
     * 
     * @return the value of field 'CLIENT_IP'.
    **/
    public java.lang.String getCLIENT_IP()
    {
        return this._CLIENT_IP;
    } //-- java.lang.String getCLIENT_IP() 

    /**
     * Returns the value of field 'MAC_ADDRESS'.
     * 
     * @return the value of field 'MAC_ADDRESS'.
    **/
    public java.lang.String getMAC_ADDRESS()
    {
        return this._MAC_ADDRESS;
    } //-- java.lang.String getMAC_ADDRESS() 

    /**
     * Returns the value of field 'MENU_ID'.
     * 
     * @return the value of field 'MENU_ID'.
    **/
    public java.lang.String getMENU_ID()
    {
        return this._MENU_ID;
    } //-- java.lang.String getMENU_ID() 

    /**
     * Returns the value of field 'OP_ID'.
     * 
     * @return the value of field 'OP_ID'.
    **/
    public java.lang.String getOP_ID()
    {
        return this._OP_ID;
    } //-- java.lang.String getOP_ID() 

    /**
     * Returns the value of field 'OP_ORG_ID'.
     * 
     * @return the value of field 'OP_ORG_ID'.
    **/
    public java.lang.String getOP_ORG_ID()
    {
        return this._OP_ORG_ID;
    } //-- java.lang.String getOP_ORG_ID() 

    /**
     * Returns the value of field 'REQ_SERIAL_NO'.
     * 
     * @return the value of field 'REQ_SERIAL_NO'.
    **/
    public java.lang.String getREQ_SERIAL_NO()
    {
        return this._REQ_SERIAL_NO;
    } //-- java.lang.String getREQ_SERIAL_NO() 

    /**
     * Returns the value of field 'SYS_OP_ID'.
     * 
     * @return the value of field 'SYS_OP_ID'.
    **/
    public java.lang.String getSYS_OP_ID()
    {
        return this._SYS_OP_ID;
    } //-- java.lang.String getSYS_OP_ID() 

    /**
     * Returns the value of field 'SYS_PASSWORD'.
     * 
     * @return the value of field 'SYS_PASSWORD'.
    **/
    public java.lang.String getSYS_PASSWORD()
    {
        return this._SYS_PASSWORD;
    } //-- java.lang.String getSYS_PASSWORD() 

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
     * Sets the value of field 'CLIENT_IP'.
     * 
     * @param CLIENT_IP the value of field 'CLIENT_IP'.
    **/
    public void setCLIENT_IP(java.lang.String CLIENT_IP)
    {
        this._CLIENT_IP = CLIENT_IP;
    } //-- void setCLIENT_IP(java.lang.String) 

    /**
     * Sets the value of field 'MAC_ADDRESS'.
     * 
     * @param MAC_ADDRESS the value of field 'MAC_ADDRESS'.
    **/
    public void setMAC_ADDRESS(java.lang.String MAC_ADDRESS)
    {
        this._MAC_ADDRESS = MAC_ADDRESS;
    } //-- void setMAC_ADDRESS(java.lang.String) 

    /**
     * Sets the value of field 'MENU_ID'.
     * 
     * @param MENU_ID the value of field 'MENU_ID'.
    **/
    public void setMENU_ID(java.lang.String MENU_ID)
    {
        this._MENU_ID = MENU_ID;
    } //-- void setMENU_ID(java.lang.String) 

    /**
     * Sets the value of field 'OP_ID'.
     * 
     * @param OP_ID the value of field 'OP_ID'.
    **/
    public void setOP_ID(java.lang.String OP_ID)
    {
        this._OP_ID = OP_ID;
    } //-- void setOP_ID(java.lang.String) 

    /**
     * Sets the value of field 'OP_ORG_ID'.
     * 
     * @param OP_ORG_ID the value of field 'OP_ORG_ID'.
    **/
    public void setOP_ORG_ID(java.lang.String OP_ORG_ID)
    {
        this._OP_ORG_ID = OP_ORG_ID;
    } //-- void setOP_ORG_ID(java.lang.String) 

    /**
     * Sets the value of field 'REQ_SERIAL_NO'.
     * 
     * @param REQ_SERIAL_NO the value of field 'REQ_SERIAL_NO'.
    **/
    public void setREQ_SERIAL_NO(java.lang.String REQ_SERIAL_NO)
    {
        this._REQ_SERIAL_NO = REQ_SERIAL_NO;
    } //-- void setREQ_SERIAL_NO(java.lang.String) 

    /**
     * Sets the value of field 'SYS_OP_ID'.
     * 
     * @param SYS_OP_ID the value of field 'SYS_OP_ID'.
    **/
    public void setSYS_OP_ID(java.lang.String SYS_OP_ID)
    {
        this._SYS_OP_ID = SYS_OP_ID;
    } //-- void setSYS_OP_ID(java.lang.String) 

    /**
     * Sets the value of field 'SYS_PASSWORD'.
     * 
     * @param SYS_PASSWORD the value of field 'SYS_PASSWORD'.
    **/
    public void setSYS_PASSWORD(java.lang.String SYS_PASSWORD)
    {
        this._SYS_PASSWORD = SYS_PASSWORD;
    } //-- void setSYS_PASSWORD(java.lang.String) 

    /**
     * 
     * 
     * @param reader
    **/
    public static PUB_INFO unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (PUB_INFO) Unmarshaller.unmarshal(PUB_INFO.class, reader);
    } //-- esbInvoke.pojo.PUB_INFO unmarshal(java.io.Reader) 

    /**
    **/
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
