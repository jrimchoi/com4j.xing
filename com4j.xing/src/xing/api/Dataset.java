package xing.api;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xing.api.dataset.IXAQuery;
import xing.api.dataset.events._IXAQueryEvents;

import com4j.EventCookie;

/**
 * ����Ÿ ��ȸ�� �������� ���Ǵ� Ŭ����(Observal) xing API�� �̺�Ʈ�� �̷�����Ƿ� wait()�� �ɾ��ٰ� ���̵�����
 * notifyAll()�� �ϱ����� Observer ������ ����Ѵ�.
 * 
 * @author sjp
 * 
 */
public class Dataset implements Observer {

	final Logger logger = LoggerFactory.getLogger(Dataset.class);

	private ResultQuery resultQuery;

	/**
	 * ���� ����
	 */
	private IXAQuery iXAQuery = ClassFactory.createXAQuery();

	public Dataset(ResultQuery resultQuery) {
		this.resultQuery = resultQuery;
		resultQuery.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object arg1) {
		logger.debug("====================update====================");
		synchronized (this) {
			this.notifyAll();
		}
	}

	
	/**
	 * ����Ÿ ��ȸ
	 * 
	 * @param queryBean
	 * @return
	 * @throws InterruptedException
	 */
	public List<Map<String, String>> getList(final QueryBean queryBean)
			throws InterruptedException {
		// logger.debug("iXAQuery::::: {}", iXAQuery.toString());

		final List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		EventCookie cookie = iXAQuery.advise(_IXAQueryEvents.class,
				new _IXAQueryEvents() {
					public void receiveData(String szTrCode) {
						logger.debug("szTrCode==>{}", szTrCode);

						Map<String, String> map;
						int count = iXAQuery.getBlockCount(queryBean
								.getOutBlock());

						logger.debug("count==>{}", count);

						Object[] outObjArr = queryBean.getOutParameters();
						String key;

						for (int i = 0; i < count; i++) {
							map = new HashMap<String, String>();

							for (int j = 0; j < outObjArr.length; j++) {
								key = (String) outObjArr[j];
								logger.debug("{}==>{}", i + 1, iXAQuery
										.getFieldData(queryBean.getOutBlock(),
												key, i));
								map.put(key, iXAQuery.getFieldData(
										queryBean.getOutBlock(), key, i));
							}

							list.add(map);
						}
					}

					public void receiveMessage(boolean bIsSystemError,
							String nMessageCode, String szMessage) {
						logger.debug(
								"bIsSystemError : {} nMessageCode : {} szMessage : {}",
								bIsSystemError, nMessageCode, szMessage);
					}
				});

		String seperator = File.separator;

		if (iXAQuery.loadFromResFile("C:" + seperator + "xingapi" + seperator
				+ "res" + seperator + queryBean.getTrCode() + ".res")) {
			logger.debug("the {}.res file is loaded", queryBean.getTrCode());
			Map<String, String> inMap = queryBean.getInParameters();
			Set<String> set = inMap.keySet();
			Iterator<String> it = set.iterator();
			String key;

			while (it.hasNext()) {
				key = it.next();
				logger.debug("key : {}, value : {}", key, inMap.get(key));
				iXAQuery.setFieldData(queryBean.getInBlock(), key,
						queryBean.getOccursData(), inMap.get(key));
			}

			logger.debug("request====>" + iXAQuery.request(false));
		}

		// logger.debug("queryBean.getTimeOut()==>{}", queryBean.getTimeOut());
		// Thread.sleep(queryBean.getTimeOut());

		Thread.sleep(6000);

		cookie.close();
		return list;
	}
}