package xing.api.session  ;

import com4j.*;

/**
 * IXASession Interface
 */
@IID("{8C0F4618-3BAB-4F19-A59B-A32E08EA711F}")
public interface IXASession extends Com4jObject {
  // Methods:
  /**
   * <p>
   * method IsLoadAPI
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  boolean isLoadAPI();


  /**
   * <p>
   * method ConnectServer
   * </p>
   * @param szServerIP Mandatory java.lang.String parameter.
   * @param nServerPort Mandatory int parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  boolean connectServer(
    java.lang.String szServerIP,
    int nServerPort);


  /**
   * <p>
   * method DisConnectServer
   * </p>
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  void disconnectServer();


  /**
   * <p>
   * method IsConnected
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  boolean isConnected();


  /**
   * <p>
   * method Login
   * </p>
   * @param szID Mandatory java.lang.String parameter.
   * @param szPwd Mandatory java.lang.String parameter.
   * @param szCertPwd Mandatory java.lang.String parameter.
   * @param nServerType Mandatory int parameter.
   * @param bShowCertErrDlg Mandatory boolean parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  boolean login(
    java.lang.String szID,
    java.lang.String szPwd,
    java.lang.String szCertPwd,
    int nServerType,
    boolean bShowCertErrDlg);


  /**
   * <p>
   * method Logout
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(12)
  boolean logout();


  /**
   * <p>
   * property ConnectTimeOut
   * </p>
   * <p>
   * Getter method for the COM property "ConnectTimeOut"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(13)
  int connectTimeOut();


  /**
   * <p>
   * property ConnectTimeOut
   * </p>
   * <p>
   * Setter method for the COM property "ConnectTimeOut"
   * </p>
   * @param pVal Mandatory int parameter.
   */

  @DISPID(8) //= 0x8. The runtime will prefer the VTID if present
  @VTID(14)
  void connectTimeOut(
    int pVal);


  /**
   * <p>
   * property SendPacketSize
   * </p>
   * <p>
   * Getter method for the COM property "SendPacketSize"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(15)
  int sendPacketSize();


  /**
   * <p>
   * property SendPacketSize
   * </p>
   * <p>
   * Setter method for the COM property "SendPacketSize"
   * </p>
   * @param pVal Mandatory int parameter.
   */

  @DISPID(9) //= 0x9. The runtime will prefer the VTID if present
  @VTID(16)
  void sendPacketSize(
    int pVal);


  /**
   * <p>
   * method GetLastError
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(10) //= 0xa. The runtime will prefer the VTID if present
  @VTID(17)
  int getLastError();


  /**
   * <p>
   * method GetErrorMessage
   * </p>
   * @param nErrorCode Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(11) //= 0xb. The runtime will prefer the VTID if present
  @VTID(18)
  java.lang.String getErrorMessage(
    int nErrorCode);


  /**
   * <p>
   * method GetCommMedia
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(12) //= 0xc. The runtime will prefer the VTID if present
  @VTID(19)
  java.lang.String getCommMedia();


  /**
   * <p>
   * method GetETKMedia
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(13) //= 0xd. The runtime will prefer the VTID if present
  @VTID(20)
  java.lang.String getETKMedia();


  /**
   * <p>
   * method GetClientIP
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(14) //= 0xe. The runtime will prefer the VTID if present
  @VTID(21)
  java.lang.String getClientIP();


  /**
   * <p>
   * method GetServerName
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(15) //= 0xf. The runtime will prefer the VTID if present
  @VTID(22)
  java.lang.String getServerName();


  /**
   * <p>
   * method GetAccountList
   * </p>
   * @param nIndex Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(16) //= 0x10. The runtime will prefer the VTID if present
  @VTID(23)
  java.lang.String getAccountList(
    int nIndex);


  /**
   * <p>
   * method GetAccountListCount
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(17) //= 0x11. The runtime will prefer the VTID if present
  @VTID(24)
  int getAccountListCount();


  // Properties:
}
