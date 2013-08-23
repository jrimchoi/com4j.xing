
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xing.api.session.ClassFactory;
import xing.api.session.IXASession;
import xing.api.session.events._IXASessionEvents;

import com4j.EventCookie;

/**
 * �α���, ������ȸ �� ���ǰ� ���õ� �޼ҵ带 ����ִ� Ŭ����
 * 
 * @author sjp
 * 
 */
public class Session {

	final Logger logger = LoggerFactory.getLogger(Session.class);

	/**
	 * ���� ����
	 */
	private IXASession iXASession = ClassFactory.createXASession();

	/**
	 * �α���
	 * 
	 * @param szID
	 *            ���̵�
	 * @param szPwd
	 *            ���̵� ��й�ȣ
	 * @param szCertPwd
	 *            ���������� ��й�ȣ
	 * @return
	 */
	public Boolean logIn(String szID, String szPwd, String szCertPwd) {
		// String directory = "C:" + File.separator + "xingapi" +
		// File.separator;
		// System.load(directory + "XA_DataSet.dll");
		// System.load(directory + "XA_Session.dll");
		// ISampleService dll = (ISampleService)Native.loadLibrary("XA_Session",
		// ISampleService.class);

		logger.debug("iXASession before ::::: {}", iXASession.toString());

		EventCookie cookie = iXASession.advise(_IXASessionEvents.class,
				new _IXASessionEvents() {
					public void login(String szCode, String szMsg) {
						logger.debug("szCode==>{}    szMsg==>{}", szCode, szMsg);
					}
				});

		iXASession.disconnectServer();

		// TO-DO : ������, �������� ������ ������
		if (iXASession.connectServer("Hts.etrade.co.kr", 20001)) { // demo.etrade.co.kr
			return iXASession.login(szID, szPwd, szCertPwd, 0, false); // 1
		}

		cookie.close();
		return false;
	}
	
	
}
