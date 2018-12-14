package training.webservice_0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.DataQualityDependencies;
import routines.Mathematical;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.DQTechnical;
import routines.MDM;
import routines.StringHandling;
import routines.DataMasking;
import routines.TalendDate;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")
/**
 * Job: WebService Purpose: <br>
 * Description:  <br>
 * @author admin@company.com
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class WebService implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "WebService.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(WebService.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset
			.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "WebService";
	private final String projectName = "TRAINING";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(
			java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources
				.entrySet()) {
			talendDataSources.put(
					dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry
							.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap
				.put(KEY_DB_DATASOURCES_RAW,
						new java.util.HashMap<String, javax.sql.DataSource>(
								dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(
			new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent,
				final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null
						&& currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE",
							getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE",
						getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent
						+ " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					WebService.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(WebService.this, new Object[] { e,
									currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tFixedFlowInput_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFlowToIterate_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tWebServiceInput_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tExtractXMLField_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row3Struct implements
			routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_TRAINING_WebService = new byte[0];
		static byte[] commonByteArray_TRAINING_WebService = new byte[0];

		public String Country;

		public String getCountry() {
			return this.Country;
		}

		public String City;

		public String getCity() {
			return this.City;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_WebService.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_WebService.length == 0) {
						commonByteArray_TRAINING_WebService = new byte[1024];
					} else {
						commonByteArray_TRAINING_WebService = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_WebService, 0, length);
				strReturn = new String(commonByteArray_TRAINING_WebService, 0,
						length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TRAINING_WebService) {

				try {

					int length = 0;

					this.Country = readString(dis);

					this.City = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Country, dos);

				// String

				writeString(this.City, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Country=" + Country);
			sb.append(",City=" + City);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (Country == null) {
				sb.append("<null>");
			} else {
				sb.append(Country);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements
			routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_TRAINING_WebService = new byte[0];
		static byte[] commonByteArray_TRAINING_WebService = new byte[0];

		public String GetCitiesByCountry;

		public String getGetCitiesByCountry() {
			return this.GetCitiesByCountry;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_WebService.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_WebService.length == 0) {
						commonByteArray_TRAINING_WebService = new byte[1024];
					} else {
						commonByteArray_TRAINING_WebService = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_WebService, 0, length);
				strReturn = new String(commonByteArray_TRAINING_WebService, 0,
						length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TRAINING_WebService) {

				try {

					int length = 0;

					this.GetCitiesByCountry = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.GetCitiesByCountry, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("GetCitiesByCountry=" + GetCitiesByCountry);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (GetCitiesByCountry == null) {
				sb.append("<null>");
			} else {
				sb.append(GetCitiesByCountry);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements
			routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_TRAINING_WebService = new byte[0];
		static byte[] commonByteArray_TRAINING_WebService = new byte[0];

		public String countryName;

		public String getCountryName() {
			return this.countryName;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_WebService.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_WebService.length == 0) {
						commonByteArray_TRAINING_WebService = new byte[1024];
					} else {
						commonByteArray_TRAINING_WebService = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_WebService, 0, length);
				strReturn = new String(commonByteArray_TRAINING_WebService, 0,
						length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos)
				throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TRAINING_WebService) {

				try {

					int length = 0;

					this.countryName = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.countryName, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("countryName=" + countryName);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (countryName == null) {
				sb.append("<null>");
			} else {
				sb.append(countryName);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(),
						object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFixedFlowInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();
row2Struct row2 = new row2Struct();
row3Struct row3 = new row3Struct();




	
	/**
	 * [tFlowToIterate_1 begin ] start
	 */

				
			int NB_ITERATE_tWebServiceInput_1 = 0; //for statistics
			

	
		
		ok_Hash.put("tFlowToIterate_1", false);
		start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());
		
	
	currentComponent="tFlowToIterate_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row1" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tFlowToIterate_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFlowToIterate_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
                    log4jParamters_tFlowToIterate_1.append("Parameters:");
                            log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "true");
                        log4jParamters_tFlowToIterate_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + (log4jParamters_tFlowToIterate_1) );
                    } 
                } 
            new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
            }

int nb_line_tFlowToIterate_1 = 0;
int counter_tFlowToIterate_1 = 0;

 



/**
 * [tFlowToIterate_1 begin ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFixedFlowInput_1", false);
		start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());
		
	
	currentComponent="tFixedFlowInput_1";

	
		int tos_count_tFixedFlowInput_1 = 0;
		

	int nb_line_tFixedFlowInput_1 = 0;
	List<row1Struct> cacheList_tFixedFlowInput_1 = new java.util.ArrayList<row1Struct>();
	row1 = new row1Struct();        	            	
	row1.countryName = "india";
	cacheList_tFixedFlowInput_1.add(row1);
	for (int i_tFixedFlowInput_1 = 0 ; i_tFixedFlowInput_1 < 1 ; i_tFixedFlowInput_1++) {	
		for(row1Struct tmpRow_tFixedFlowInput_1 : cacheList_tFixedFlowInput_1){
			nb_line_tFixedFlowInput_1 ++;		
			row1 = tmpRow_tFixedFlowInput_1;
 



/**
 * [tFixedFlowInput_1 begin ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 main ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 


	tos_count_tFixedFlowInput_1++;

/**
 * [tFixedFlowInput_1 main ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tFlowToIterate_1 main ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

			//row1
			//row1


			
				if(execStat){
					runStat.updateStatOnConnection("row1"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		


    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_1 - "  + ("Set global var, key=row1.countryName, value=")  + (row1.countryName)  + (".") );            
            globalMap.put("row1.countryName", row1.countryName);
    	
 
	   nb_line_tFlowToIterate_1++;  
       counter_tFlowToIterate_1++;
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Current iteration is: ")  + (counter_tFlowToIterate_1)  + (".") );
       globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);
 


	tos_count_tFlowToIterate_1++;

/**
 * [tFlowToIterate_1 main ] stop
 */
	
	/**
	 * [tFlowToIterate_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 process_data_begin ] stop
 */
	NB_ITERATE_tWebServiceInput_1++;
	
	
					if(execStat){				
	       				runStat.updateStatOnConnection("row3", 3, 0);
					}           			
				
					if(execStat){				
	       				runStat.updateStatOnConnection("row2", 3, 0);
					}           			
				
				if(execStat){
					runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tWebServiceInput_1);
					//Thread.sleep(1000);
				}				
			



	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row3" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
                    log4jParamters_tLogRow_1.append("Parameters:");
                            log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[2];

        public void addRow(String[] row) {

            for (int i = 0; i < 2; i++) {
                if (row[i]!=null) {
                  colLengths[i] = Math.max(colLengths[i], row[i].length());
                }
            }
            list.add(row);
        }

        public void setTableName(String name) {

            this.name = name;
        }

            public StringBuilder format() {
            
                StringBuilder sb = new StringBuilder();
  
            
                    sb.append(print(des_top));
    
                    int totals = 0;
                    for (int i = 0; i < colLengths.length; i++) {
                        totals = totals + colLengths[i];
                    }
    
                    // name
                    sb.append("|");
                    int k = 0;
                    for (k = 0; k < (totals + 1 - name.length()) / 2; k++) {
                        sb.append(' ');
                    }
                    sb.append(name);
                    for (int i = 0; i < totals + 1 - name.length() - k; i++) {
                        sb.append(' ');
                    }
                    sb.append("|\n");

                    // head and rows
                    sb.append(print(des_head));
                    for (int i = 0; i < list.size(); i++) {
    
                        String[] row = list.get(i);
    
                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());
                        
                        StringBuilder sbformat = new StringBuilder();                                             
        			        sbformat.append("|%1$-");
        			        sbformat.append(colLengths[0]);
        			        sbformat.append("s");
        			              
        			        sbformat.append("|%2$-");
        			        sbformat.append(colLengths[1]);
        			        sbformat.append("s");
        			                      
                        sbformat.append("|\n");                    
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
                        sb.append(formatter.toString());
                        if (i == 0)
                            sb.append(print(des_head)); // print the head
                    }
    
                    // end
                    sb.append(print(des_bottom));
                    return sb;
                }
            

            private StringBuilder print(String[] fillChars) {
                StringBuilder sb = new StringBuilder();
                //first column
                sb.append(fillChars[0]);                
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }
                    sb.append(fillChars[3]);	                

                
                    //last column
                    for (int i = 0; i < colLengths[1] - fillChars[1].length() + 1; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"Country","City",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tExtractXMLField_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tExtractXMLField_1", false);
		start_Hash.put("tExtractXMLField_1", System.currentTimeMillis());
		
	
	currentComponent="tExtractXMLField_1";

	
			if (execStat) {
				if(resourceMap.get("inIterateVComp") == null){
					
						runStat.updateStatOnConnection("row2" + iterateId, 0, 0);
					
				}
			} 

		
		int tos_count_tExtractXMLField_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tExtractXMLField_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tExtractXMLField_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tExtractXMLField_1 = new StringBuilder();
                    log4jParamters_tExtractXMLField_1.append("Parameters:");
                            log4jParamters_tExtractXMLField_1.append("XMLFIELD" + " = " + "GetCitiesByCountry");
                        log4jParamters_tExtractXMLField_1.append(" | ");
                            log4jParamters_tExtractXMLField_1.append("LOOP_QUERY" + " = " + "\"/NewDataSet/Table\"");
                        log4jParamters_tExtractXMLField_1.append(" | ");
                            log4jParamters_tExtractXMLField_1.append("MAPPING" + " = " + "[{QUERY="+("\"./Country\"")+", NODECHECK="+("false")+", SCHEMA_COLUMN="+("Country")+"}, {QUERY="+("\"./City\"")+", NODECHECK="+("false")+", SCHEMA_COLUMN="+("City")+"}]");
                        log4jParamters_tExtractXMLField_1.append(" | ");
                            log4jParamters_tExtractXMLField_1.append("LIMIT" + " = " + "");
                        log4jParamters_tExtractXMLField_1.append(" | ");
                            log4jParamters_tExtractXMLField_1.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tExtractXMLField_1.append(" | ");
                            log4jParamters_tExtractXMLField_1.append("IGNORE_NS" + " = " + "false");
                        log4jParamters_tExtractXMLField_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tExtractXMLField_1 - "  + (log4jParamters_tExtractXMLField_1) );
                    } 
                } 
            new BytesLimit65535_tExtractXMLField_1().limitLog4jByte();
            }

int nb_line_tExtractXMLField_1 = 0;

class NameSpaceTool_tExtractXMLField_1 {

    public java.util.HashMap<String, String> xmlNameSpaceMap = new java.util.HashMap<String, String>();
    
	private java.util.List<String> defualtNSPath = new java.util.ArrayList<String>();

    public void countNSMap(org.dom4j.Element el) {
        for (org.dom4j.Namespace ns : (java.util.List<org.dom4j.Namespace>) el.declaredNamespaces()) {
            if (ns.getPrefix().trim().length() == 0) {
                xmlNameSpaceMap.put("pre"+defualtNSPath.size(), ns.getURI());
                String path = "";
                org.dom4j.Element elTmp = el;
                while (elTmp != null) {
                   	if (elTmp.getNamespacePrefix() != null && elTmp.getNamespacePrefix().length() > 0) {
                        path = "/" + elTmp.getNamespacePrefix() + ":" + elTmp.getName() + path;
                    } else {
                        path = "/" + elTmp.getName() + path;
                    }
                    elTmp = elTmp.getParent();
                }
                defualtNSPath.add(path);
            } else {
                xmlNameSpaceMap.put(ns.getPrefix(), ns.getURI());
            }

        }
        for (org.dom4j.Element e : (java.util.List<org.dom4j.Element>) el.elements()) {
            countNSMap(e);
        }
    }
    
    /**
	 *	the regex for the xpath like that : 
	 *	case 1 : functionA(locationXPathExpression) 
	 *	case 2 : fn:functionA(locationXPathExpression) 
	 *	case 3 : functionA(functionB(locationXPathExpression))
	 *	case 4 : fn:functionA(fn:functionB(locationXPathExpression))
	 *	and like that.
	*/
	private java.util.regex.Pattern simpleFunctionPattern;
	private StringBuffer stringBuffer;
	private java.util.Map<String,String> resultCache;
	
	public String addDefaultNSPrefix(final String xpathExpression, String loopPath) {
	    if (defualtNSPath.size() < 1) {
        	return xpathExpression;
    	}
    	
    	if(resultCache == null) {
    		resultCache = new java.util.HashMap<String,String>();
    	}
    	
    	String resultXpathExpression = resultCache.get(xpathExpression);
		if(resultXpathExpression!=null) {
    		return resultXpathExpression;
    	}
    	
    	String locationPathExpression = xpathExpression;
    	
    	if(simpleFunctionPattern == null) {
    		simpleFunctionPattern = java.util.regex.Pattern.compile("([a-zA-z0-9]+:)?[a-zA-Z]+-?[A-Za-z]+\\(.*\\)");
    	}
    	
    	boolean isSimpleFunctionXPath = simpleFunctionPattern.matcher(xpathExpression).matches();
    	String tail = null;
    	if(isSimpleFunctionXPath) {
			int start = xpathExpression.lastIndexOf('(');
			int end = xpathExpression.indexOf(')');
			if(start < end) {
			    if(stringBuffer == null) {
    				stringBuffer = new StringBuffer();
    			}
				locationPathExpression = xpathExpression.substring(start+1,end);
				stringBuffer.append(xpathExpression.substring(0,start+1));
				tail = xpathExpression.substring(end);
			} else {
				isSimpleFunctionXPath = false;
			}
    	}
    	
    	locationPathExpression = addDefaultNSPrefixForLocationXPathExpression(locationPathExpression,loopPath);
    	
    	resultXpathExpression = locationPathExpression;
    	
    	if(isSimpleFunctionXPath) {
        	stringBuffer.append(locationPathExpression);
    		stringBuffer.append(tail);
    		resultXpathExpression = stringBuffer.toString();
    		stringBuffer.setLength(0);
        }
    	
    	resultCache.put(xpathExpression,resultXpathExpression);
    	return resultXpathExpression;
	}
	
    private String addDefaultNSPrefixForLocationXPathExpression(String path, String loopPath) {
    	String fullPath = loopPath;
    	if(!path.equals(fullPath)){
        	for (String tmp : path.split("/")) {
        		if (("..").equals(tmp)) {
                    fullPath = fullPath.substring(0, fullPath.lastIndexOf("/"));
                } else {
                    fullPath += "/" + tmp;
                }
        	}
        }
    	int[] indexs = new int[fullPath.split("/").length - 1];
        java.util.Arrays.fill(indexs, -1);
        int length = 0;
        for (int i = 0; i < defualtNSPath.size(); i++) {
            if (defualtNSPath.get(i).length() > length && fullPath.startsWith(defualtNSPath.get(i))) {
                java.util.Arrays.fill(indexs, defualtNSPath.get(i).split("/").length - 2, indexs.length, i);
                length = defualtNSPath.get(i).length();
            }
        }
    
        StringBuilder newPath = new StringBuilder();
        String[] pathStrs = path.split("/");
        for (int i = 0; i < pathStrs.length; i++) {
            String tmp = pathStrs[i];
            if (newPath.length() > 0) {
                newPath.append("/");
            }
            if (tmp.length() > 0 && tmp.indexOf(":") == -1 && tmp.indexOf(".") == -1 /*&& tmp.indexOf("@") == -1*/) {
                int index = indexs[i + indexs.length - pathStrs.length];
                if (index >= 0) {
                	//==== add by wliu to support both filter and functions==
    				if(tmp.indexOf("[")>0 && tmp.indexOf("]")>tmp.indexOf("[")){//include filter
    					String tmpStr=replaceElementWithNS(tmp,"pre"+index+":");
    					newPath.append(tmpStr);
    				}else{
    					if(tmp.indexOf("@") != -1 || tmp.indexOf("(")<tmp.indexOf(")")){  // include attribute
    						newPath.append(tmp);
    					}else{
    				//==add end=======	
                    		newPath.append("pre").append(index).append(":").append(tmp);
                    	}
                    }                    
                } else {
                    newPath.append(tmp);
                }
            } else {
                newPath.append(tmp);
            }
        }
        return newPath.toString();
    }
    
	private String matches = "@*\\b[a-z|A-Z|_]+[[-]*\\w]*\\b[^'|^\\(]";
    private java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(matches);
    
	private String replaceElementWithNS(String global, String pre){

        java.util.regex.Matcher match = pattern.matcher(global);
        StringBuffer sb = new StringBuffer();
        match.reset();
        while (match.find()) {
            String group = match.group();
            String tmp = "";
            if (group.toLowerCase().matches("\\b(div|mod|and|or)\\b.*") || group.matches("@.*")) {
                tmp = group;
            } else {
                tmp = tmp + pre + group;
            }
            match.appendReplacement(sb, tmp);
        }
        match.appendTail(sb);
        
        return sb.toString();
	}
	
}

class XML_API_tExtractXMLField_1{
	public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        if (node != null && node instanceof org.dom4j.Element) {
        	org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute("nil");
        	if(attri != null && ("true").equals(attri.getText())){
            	return true;
            }
        }
        return false;
    }

    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        return node == null ? true : false;
    }

    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        if (node != null) {
            return node.getText().length() == 0;
        }
        return false;
    }
}

XML_API_tExtractXMLField_1 xml_api_tExtractXMLField_1 = new XML_API_tExtractXMLField_1();
 



/**
 * [tExtractXMLField_1 begin ] stop
 */



	
	/**
	 * [tWebServiceInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tWebServiceInput_1", false);
		start_Hash.put("tWebServiceInput_1", System.currentTimeMillis());
		
	
	currentComponent="tWebServiceInput_1";

	
		int tos_count_tWebServiceInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tWebServiceInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tWebServiceInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tWebServiceInput_1 = new StringBuilder();
                    log4jParamters_tWebServiceInput_1.append("Parameters:");
                            log4jParamters_tWebServiceInput_1.append("ENDPOINT" + " = " + "“http://www.webservicex.net/globalweather.asmx?WSDL”");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("NEED_AUTH" + " = " + "false");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("UES_PROXY" + " = " + "false");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("NEED_SSL_TO_TRUSTSERVER" + " = " + "false");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("METHOD" + " = " + "\"GetCitiesByCountry\"");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("TIMEOUT" + " = " + "20");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("PARAMS" + " = " + "[{VALUE="+("(String)globalMap.get(\"row1.countryName\")")+"}]");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                            log4jParamters_tWebServiceInput_1.append("ADVANCED_USE" + " = " + "false");
                        log4jParamters_tWebServiceInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tWebServiceInput_1 - "  + (log4jParamters_tWebServiceInput_1) );
                    } 
                } 
            new BytesLimit65535_tWebServiceInput_1().limitLog4jByte();
            }

				/////////////////////////////////// 
		        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		        Object[] params_tWebServiceInput_1 = new Object[] {
			        “http://www.webservicex.net/globalweather.asmx?WSDL”, 
			        "GetCitiesByCountry",      
					
			    	    (String)globalMap.get("row1.countryName"),
					      
		        };
				 
				org.talend.DynamicInvoker.setTimeOut(20);
			
				
                if(log.isInfoEnabled())
            log.info("tWebServiceInput_1 - "  + ("Sending soap request to endpoint.") );
		 		org.talend.DynamicInvoker.main(params_tWebServiceInput_1);
		 		java.util.Map result_tWebServiceInput_1 = org.talend.DynamicInvoker.getResult();
		        
		        Object[] results_tWebServiceInput_1 = null;
			    int nb_line_tWebServiceInput_1 = 0;
			
		        for (Object key_tWebServiceInput_1 : result_tWebServiceInput_1.keySet()) {
	        
		           results_tWebServiceInput_1 = new Object[1];
		            
		           Object value_tWebServiceInput_1 = result_tWebServiceInput_1.get(key_tWebServiceInput_1);
		           if (value_tWebServiceInput_1 instanceof Object[]){
		                Object[] objArr_tWebServiceInput_1 = (Object[])value_tWebServiceInput_1;
		                int len_tWebServiceInput_1 = Math.min(objArr_tWebServiceInput_1.length, results_tWebServiceInput_1.length);
		                int k_tWebServiceInput_1 = 0;
		                for (int i_tWebServiceInput_1 = 0; i_tWebServiceInput_1 < len_tWebServiceInput_1; i_tWebServiceInput_1++ ) {
		                    results_tWebServiceInput_1[k_tWebServiceInput_1] = objArr_tWebServiceInput_1[k_tWebServiceInput_1];
		                }
	                
			        } else if (value_tWebServiceInput_1 instanceof java.util.List) {
			        	java.util.List list_tWebServiceInput_1 = (java.util.List)value_tWebServiceInput_1;
			            int len_tWebServiceInput_1 = Math.min(list_tWebServiceInput_1.size(), results_tWebServiceInput_1.length);
			            int k_tWebServiceInput_1 = 0;
			            for (java.util.Iterator iter_tWebServiceInput_1 = list_tWebServiceInput_1.iterator(); iter_tWebServiceInput_1.hasNext() && k_tWebServiceInput_1 < len_tWebServiceInput_1; k_tWebServiceInput_1++) {
			            	results_tWebServiceInput_1[k_tWebServiceInput_1] = iter_tWebServiceInput_1.next();
			            }
	                                
	           		} else if (value_tWebServiceInput_1 instanceof java.util.Map) {                
						java.util.Map map_tWebServiceInput_1 = (java.util.Map)value_tWebServiceInput_1;
		                java.util.Collection values_tWebServiceInput_1 = map_tWebServiceInput_1.values();
		                int len_tWebServiceInput_1 = Math.min(values_tWebServiceInput_1.size(), results_tWebServiceInput_1.length);
		                int k_tWebServiceInput_1 = 0;
		                for (java.util.Iterator iter_tWebServiceInput_1 = values_tWebServiceInput_1.iterator(); iter_tWebServiceInput_1.hasNext() && k_tWebServiceInput_1 < len_tWebServiceInput_1; k_tWebServiceInput_1++) {
		                    results_tWebServiceInput_1[k_tWebServiceInput_1] = iter_tWebServiceInput_1.next();
		                }
	
	            	} else if (value_tWebServiceInput_1 instanceof org.w3c.dom.Element) {
	                	results_tWebServiceInput_1[0] = org.apache.axis.utils.XMLUtils.ElementToString((org.w3c.dom.Element)value_tWebServiceInput_1);
	                
		            }else if (value_tWebServiceInput_1 instanceof org.apache.axis.types.Schema){
		                org.apache.axis.types.Schema schema_tWebServiceInput_1 = (org.apache.axis.types.Schema) value_tWebServiceInput_1;
		                org.apache.axis.message.MessageElement[] _any_tWebServiceInput_1 = schema_tWebServiceInput_1.get_any();
		                for (int s_tWebServiceInput_1 = 0; s_tWebServiceInput_1 < _any_tWebServiceInput_1.length; s_tWebServiceInput_1++) {
		                    results_tWebServiceInput_1[s_tWebServiceInput_1] = _any_tWebServiceInput_1[s_tWebServiceInput_1].toString();
		                }	
		                
		            } else {
					    results_tWebServiceInput_1[0] = value_tWebServiceInput_1;
		            }
	            
			            
		
	        nb_line_tWebServiceInput_1++;
		       
			// for output
			
								
					
							if(0 < results_tWebServiceInput_1.length && results_tWebServiceInput_1[0]!=null){				
								
									row2.GetCitiesByCountry = results_tWebServiceInput_1[0].toString();
								
							} else { 
								row2.GetCitiesByCountry = null;
							}
						
                if(log.isDebugEnabled())
            log.debug("tWebServiceInput_1 - "  + ("Retrieving the record ")  + (nb_line_tWebServiceInput_1)  + (".") );
		///////////////////////////////////       
		
  

 



/**
 * [tWebServiceInput_1 begin ] stop
 */
	
	/**
	 * [tWebServiceInput_1 main ] start
	 */

	

	
	
	currentComponent="tWebServiceInput_1";

	

 


	tos_count_tWebServiceInput_1++;

/**
 * [tWebServiceInput_1 main ] stop
 */
	
	/**
	 * [tWebServiceInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tWebServiceInput_1";

	

 



/**
 * [tWebServiceInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tExtractXMLField_1 main ] start
	 */

	

	
	
	currentComponent="tExtractXMLField_1";

	

			//row2
			//row2


			
				if(execStat){
					runStat.updateStatOnConnection("row2"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		

	String xmlStr_tExtractXMLField_1 = null;
	routines.system.Document xmlDocument_tExtractXMLField_1 = null;
	if(row2.GetCitiesByCountry!=null){
				xmlStr_tExtractXMLField_1 = row2.GetCitiesByCountry;
	}
			if(xmlStr_tExtractXMLField_1!=null){// C_01
row3 = null;
	NameSpaceTool_tExtractXMLField_1 nsTool_tExtractXMLField_1 = new NameSpaceTool_tExtractXMLField_1();
    org.dom4j.io.SAXReader reader_tExtractXMLField_1 = new org.dom4j.io.SAXReader();
	
    org.dom4j.Document doc_tExtractXMLField_1 = null;
    java.util.HashMap xmlNameSpaceMap_tExtractXMLField_1 = null;
    org.dom4j.XPath x_tExtractXMLField_1 = null;
    java.util.List<org.dom4j.tree.AbstractNode> nodeList_tExtractXMLField_1 = null;
		String loopQuery_tExtractXMLField_1 = "/NewDataSet/Table"; 
	
    boolean isStructError_tExtractXMLField_1= true;
        
    try{
		
	    	doc_tExtractXMLField_1= reader_tExtractXMLField_1.read(new java.io.StringReader(xmlStr_tExtractXMLField_1));
	    
	    nsTool_tExtractXMLField_1.countNSMap(doc_tExtractXMLField_1.getRootElement());
	    xmlNameSpaceMap_tExtractXMLField_1 = nsTool_tExtractXMLField_1.xmlNameSpaceMap;

    	x_tExtractXMLField_1 = doc_tExtractXMLField_1.createXPath(nsTool_tExtractXMLField_1.addDefaultNSPrefix(loopQuery_tExtractXMLField_1,loopQuery_tExtractXMLField_1));
      
    	x_tExtractXMLField_1.setNamespaceURIs(xmlNameSpaceMap_tExtractXMLField_1); 
    
		 
    	nodeList_tExtractXMLField_1 = (java.util.List<org.dom4j.tree.AbstractNode>)x_tExtractXMLField_1.selectNodes(doc_tExtractXMLField_1);
    	
    	isStructError_tExtractXMLField_1 = false;
    	
    }catch(java.lang.Exception ex_tExtractXMLField_1){
	log.error("tExtractXMLField_1 - " + ex_tExtractXMLField_1.getMessage());
    System.err.println(ex_tExtractXMLField_1.getMessage());
    }
    
    org.dom4j.Node node_tExtractXMLField_1 = null;
    String str_tExtractXMLField_1 = "";
    boolean resultIsNode_tExtractXMLField_1 = true;
    for(int i_tExtractXMLField_1=0; isStructError_tExtractXMLField_1 || (nodeList_tExtractXMLField_1!=null && i_tExtractXMLField_1 < nodeList_tExtractXMLField_1.size());i_tExtractXMLField_1++){
    	
    	if(!isStructError_tExtractXMLField_1){
			row3 = null;
    		row3 = new row3Struct();
    	
    		org.dom4j.tree.AbstractNode temp_tExtractXMLField_1 = nodeList_tExtractXMLField_1.get(i_tExtractXMLField_1);
	
	    	nb_line_tExtractXMLField_1++;	
				log.debug("tExtractXMLField_1 - Processing the record " + nb_line_tExtractXMLField_1 + ".");
			
			try{
				org.dom4j.XPath xTmp0_tExtractXMLField_1 = temp_tExtractXMLField_1.createXPath(nsTool_tExtractXMLField_1.addDefaultNSPrefix("./Country",loopQuery_tExtractXMLField_1));
			    xTmp0_tExtractXMLField_1.setNamespaceURIs(xmlNameSpaceMap_tExtractXMLField_1);
				
			    Object obj0_tExtractXMLField_1 = xTmp0_tExtractXMLField_1.evaluate(temp_tExtractXMLField_1);
			    if(obj0_tExtractXMLField_1 instanceof String || obj0_tExtractXMLField_1 instanceof Number){
			    	resultIsNode_tExtractXMLField_1 = false;
    				str_tExtractXMLField_1 = String.valueOf(obj0_tExtractXMLField_1);
   				}else{
   					resultIsNode_tExtractXMLField_1 = true;
				    node_tExtractXMLField_1 = xTmp0_tExtractXMLField_1.selectSingleNode(temp_tExtractXMLField_1);
				    str_tExtractXMLField_1 = xTmp0_tExtractXMLField_1.valueOf(temp_tExtractXMLField_1);
				}
									if(resultIsNode_tExtractXMLField_1 && xml_api_tExtractXMLField_1.isDefNull(node_tExtractXMLField_1)){
											row3.Country =null;
									}else if(resultIsNode_tExtractXMLField_1 && xml_api_tExtractXMLField_1.isEmpty(node_tExtractXMLField_1)){
										row3.Country ="";
									}else if(resultIsNode_tExtractXMLField_1 && xml_api_tExtractXMLField_1.isMissing(node_tExtractXMLField_1 )){ 
										row3.Country =null;
									}else{
				row3.Country = str_tExtractXMLField_1;
									}
				org.dom4j.XPath xTmp1_tExtractXMLField_1 = temp_tExtractXMLField_1.createXPath(nsTool_tExtractXMLField_1.addDefaultNSPrefix("./City",loopQuery_tExtractXMLField_1));
			    xTmp1_tExtractXMLField_1.setNamespaceURIs(xmlNameSpaceMap_tExtractXMLField_1);
				
			    Object obj1_tExtractXMLField_1 = xTmp1_tExtractXMLField_1.evaluate(temp_tExtractXMLField_1);
			    if(obj1_tExtractXMLField_1 instanceof String || obj1_tExtractXMLField_1 instanceof Number){
			    	resultIsNode_tExtractXMLField_1 = false;
    				str_tExtractXMLField_1 = String.valueOf(obj1_tExtractXMLField_1);
   				}else{
   					resultIsNode_tExtractXMLField_1 = true;
				    node_tExtractXMLField_1 = xTmp1_tExtractXMLField_1.selectSingleNode(temp_tExtractXMLField_1);
				    str_tExtractXMLField_1 = xTmp1_tExtractXMLField_1.valueOf(temp_tExtractXMLField_1);
				}
									if(resultIsNode_tExtractXMLField_1 && xml_api_tExtractXMLField_1.isDefNull(node_tExtractXMLField_1)){
											row3.City =null;
									}else if(resultIsNode_tExtractXMLField_1 && xml_api_tExtractXMLField_1.isEmpty(node_tExtractXMLField_1)){
										row3.City ="";
									}else if(resultIsNode_tExtractXMLField_1 && xml_api_tExtractXMLField_1.isMissing(node_tExtractXMLField_1 )){ 
										row3.City =null;
									}else{
				row3.City = str_tExtractXMLField_1;
									}
}catch(java.lang.Exception ex_tExtractXMLField_1){
	log.error("tExtractXMLField_1 - " + ex_tExtractXMLField_1.getMessage());
    System.err.println(ex_tExtractXMLField_1.getMessage());
    row3 = null;
    	}
    }
    
    isStructError_tExtractXMLField_1 = false;


   globalMap.put("tExtractXMLField_1_NB_LINE", nb_line_tExtractXMLField_1);

 


	tos_count_tExtractXMLField_1++;

/**
 * [tExtractXMLField_1 main ] stop
 */
	
	/**
	 * [tExtractXMLField_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tExtractXMLField_1";

	

 



/**
 * [tExtractXMLField_1 process_data_begin ] stop
 */
// Start of branch "row3"
if(row3 != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

			//row3
			//row3


			
				if(execStat){
					runStat.updateStatOnConnection("row3"+iterateId,1, 1);
				} 
			

		
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[2];
   				
	    		if(row3.Country != null) { //              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(row3.Country)			
					          ;	
							
	    		} //			
    			   				
	    		if(row3.City != null) { //              
                 row_tLogRow_1[1]=    						    
				                String.valueOf(row3.City)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
                	log.info("tLogRow_1 - Content of row "+nb_line_tLogRow_1+": " + TalendString.unionString("|",row_tLogRow_1));
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "row3"

		// end for
	}


	
		} // C_01
	
	
	/**
	 * [tExtractXMLField_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tExtractXMLField_1";

	

 



/**
 * [tExtractXMLField_1 process_data_end ] stop
 */



	
	/**
	 * [tWebServiceInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tWebServiceInput_1";

	

 



/**
 * [tWebServiceInput_1 process_data_end ] stop
 */
	
	/**
	 * [tWebServiceInput_1 end ] start
	 */

	

	
	
	currentComponent="tWebServiceInput_1";

	

	}
	globalMap.put("tWebServiceInput_1_NB_LINE", nb_line_tWebServiceInput_1);

                if(log.isInfoEnabled())
            log.info("tWebServiceInput_1 - "  + ("Retrieved records count: ")  + (nb_line_tWebServiceInput_1)  + (".") );
 
                if(log.isDebugEnabled())
            log.debug("tWebServiceInput_1 - "  + ("Done.") );

ok_Hash.put("tWebServiceInput_1", true);
end_Hash.put("tWebServiceInput_1", System.currentTimeMillis());




/**
 * [tWebServiceInput_1 end ] stop
 */

	
	/**
	 * [tExtractXMLField_1 end ] start
	 */

	

	
	
	currentComponent="tExtractXMLField_1";

	



globalMap.put("tExtractXMLField_1_NB_LINE", nb_line_tExtractXMLField_1);

				log.debug("tExtractXMLField_1 - Processed records count: " + nb_line_tExtractXMLField_1 + " .");
			
			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row2"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tExtractXMLField_1 - "  + ("Done.") );

ok_Hash.put("tExtractXMLField_1", true);
end_Hash.put("tExtractXMLField_1", System.currentTimeMillis());




/**
 * [tExtractXMLField_1 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row3"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */






						if(execStat){
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tWebServiceInput_1);
						}				
					




	
	/**
	 * [tFlowToIterate_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 process_data_end ] stop
 */



	
	/**
	 * [tFixedFlowInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 process_data_end ] stop
 */
	
	/**
	 * [tFixedFlowInput_1 end ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

		}
	}
	cacheList_tFixedFlowInput_1.clear();
	globalMap.put("tFixedFlowInput_1_NB_LINE", nb_line_tFixedFlowInput_1);

 

ok_Hash.put("tFixedFlowInput_1", true);
end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());




/**
 * [tFixedFlowInput_1 end ] stop
 */

	
	/**
	 * [tFlowToIterate_1 end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

globalMap.put("tFlowToIterate_1_NB_LINE",nb_line_tFlowToIterate_1);
			if(execStat){
				if(resourceMap.get("inIterateVComp") == null || !((Boolean)resourceMap.get("inIterateVComp"))){
			 		runStat.updateStatOnConnection("row1"+iterateId,2, 0); 
			 	}
			}
		
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_1", true);
end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());




/**
 * [tFlowToIterate_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFixedFlowInput_1 finally ] start
	 */

	

	
	
	currentComponent="tFixedFlowInput_1";

	

 



/**
 * [tFixedFlowInput_1 finally ] stop
 */

	
	/**
	 * [tFlowToIterate_1 finally ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";

	

 



/**
 * [tFlowToIterate_1 finally ] stop
 */

	
	/**
	 * [tWebServiceInput_1 finally ] start
	 */

	

	
	
	currentComponent="tWebServiceInput_1";

	

 



/**
 * [tWebServiceInput_1 finally ] stop
 */

	
	/**
	 * [tExtractXMLField_1 finally ] start
	 */

	

	
	
	currentComponent="tExtractXMLField_1";

	

 



/**
 * [tExtractXMLField_1 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	private PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final WebService WebServiceClass = new WebService();

		int exitCode = WebServiceClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'WebService' - Done.");
		}

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		if (!"".equals(log4jLevel)) {
			if ("trace".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				log.setLevel(org.apache.log4j.Level.OFF);
			}
			org.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());
		}
		log.info("TalendJob: 'WebService' - Start.");

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket
				// can't open
				System.err.println("The statistics socket port " + portStats
						+ " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = WebService.class.getClassLoader()
					.getResourceAsStream(
							"training/webservice_0_1/contexts/" + contextStr
									+ ".properties");
			if (inContext == null) {
				inContext = WebService.class
						.getClassLoader()
						.getResourceAsStream(
								"config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				// defaultProps is in order to keep the original context value
				defaultProps.load(inContext);
				inContext.close();
				context = new ContextProperties(defaultProps);
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param
				// is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param
							.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tFixedFlowInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tFixedFlowInput_1) {
			globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", -1);

			e_tFixedFlowInput_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory()
				- Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : WebService");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;
		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher,
				Thread.currentThread().getId() + "", "", "" + returnCode, "",
				"", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index),
							keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		}

	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" },
			{ "\\'", "\'" }, { "\\r", "\r" }, { "\\f", "\f" }, { "\\b", "\b" },
			{ "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex,
							index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left
			// into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 77739 characters generated by Talend Data Fabric on the December 14, 2018
 * 2:13:39 PM EST
 ************************************************************************************************/
