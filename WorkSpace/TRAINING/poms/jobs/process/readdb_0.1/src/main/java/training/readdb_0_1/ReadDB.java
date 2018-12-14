package training.readdb_0_1;

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
 * Job: ReadDB Purpose: <br>
 * Description:  <br>
 * @author student@company.com
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class ReadDB implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "ReadDB.log");
	}
	private static org.apache.log4j.Logger log = org.apache.log4j.Logger
			.getLogger(ReadDB.class);

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

			if (AdventureWorks2016_Schema != null) {

				this.setProperty("AdventureWorks2016_Schema",
						AdventureWorks2016_Schema.toString());

			}

			if (AdventureWorks2016_Database != null) {

				this.setProperty("AdventureWorks2016_Database",
						AdventureWorks2016_Database.toString());

			}

			if (AdventureWorks2016_Login != null) {

				this.setProperty("AdventureWorks2016_Login",
						AdventureWorks2016_Login.toString());

			}

			if (AdventureWorks2016_Password != null) {

				this.setProperty("AdventureWorks2016_Password",
						AdventureWorks2016_Password.toString());

			}

			if (AdventureWorks2016_AdditionalParams != null) {

				this.setProperty("AdventureWorks2016_AdditionalParams",
						AdventureWorks2016_AdditionalParams.toString());

			}

			if (AdventureWorks2016_Server != null) {

				this.setProperty("AdventureWorks2016_Server",
						AdventureWorks2016_Server.toString());

			}

			if (AdventureWorks2016_Port != null) {

				this.setProperty("AdventureWorks2016_Port",
						AdventureWorks2016_Port.toString());

			}

		}

		public String AdventureWorks2016_Schema;

		public String getAdventureWorks2016_Schema() {
			return this.AdventureWorks2016_Schema;
		}

		public String AdventureWorks2016_Database;

		public String getAdventureWorks2016_Database() {
			return this.AdventureWorks2016_Database;
		}

		public String AdventureWorks2016_Login;

		public String getAdventureWorks2016_Login() {
			return this.AdventureWorks2016_Login;
		}

		public java.lang.String AdventureWorks2016_Password;

		public java.lang.String getAdventureWorks2016_Password() {
			return this.AdventureWorks2016_Password;
		}

		public String AdventureWorks2016_AdditionalParams;

		public String getAdventureWorks2016_AdditionalParams() {
			return this.AdventureWorks2016_AdditionalParams;
		}

		public String AdventureWorks2016_Server;

		public String getAdventureWorks2016_Server() {
			return this.AdventureWorks2016_Server;
		}

		public String AdventureWorks2016_Port;

		public String getAdventureWorks2016_Port() {
			return this.AdventureWorks2016_Port;
		}
	}

	private ContextProperties context = new ContextProperties();

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "ReadDB";
	private final String projectName = "TRAINING";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

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
					ReadDB.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(ReadDB.this, new Object[] { e,
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

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileOutputDelimited_1_error(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception,
			String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread
				.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(),
				ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class OutStruct implements
			routines.system.IPersistableRow<OutStruct> {
		final static byte[] commonByteArrayLock_TRAINING_ReadDB = new byte[0];
		static byte[] commonByteArray_TRAINING_ReadDB = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int AddressID;

		public int getAddressID() {
			return this.AddressID;
		}

		public String AddressLine1;

		public String getAddressLine1() {
			return this.AddressLine1;
		}

		public String AddressLine2;

		public String getAddressLine2() {
			return this.AddressLine2;
		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public int StateProvinceID;

		public int getStateProvinceID() {
			return this.StateProvinceID;
		}

		public String PostalCode;

		public String getPostalCode() {
			return this.PostalCode;
		}

		public String SpatialLocation;

		public String getSpatialLocation() {
			return this.SpatialLocation;
		}

		public Object rowguid;

		public Object getRowguid() {
			return this.rowguid;
		}

		public java.util.Date ModifiedDate;

		public java.util.Date getModifiedDate() {
			return this.ModifiedDate;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.AddressID;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final OutStruct other = (OutStruct) obj;

			if (this.AddressID != other.AddressID)
				return false;

			return true;
		}

		public void copyDataTo(OutStruct other) {

			other.AddressID = this.AddressID;
			other.AddressLine1 = this.AddressLine1;
			other.AddressLine2 = this.AddressLine2;
			other.City = this.City;
			other.StateProvinceID = this.StateProvinceID;
			other.PostalCode = this.PostalCode;
			other.SpatialLocation = this.SpatialLocation;
			other.rowguid = this.rowguid;
			other.ModifiedDate = this.ModifiedDate;

		}

		public void copyKeysDataTo(OutStruct other) {

			other.AddressID = this.AddressID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_ReadDB.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_ReadDB.length == 0) {
						commonByteArray_TRAINING_ReadDB = new byte[1024];
					} else {
						commonByteArray_TRAINING_ReadDB = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_ReadDB, 0, length);
				strReturn = new String(commonByteArray_TRAINING_ReadDB, 0,
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

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TRAINING_ReadDB) {

				try {

					int length = 0;

					this.AddressID = dis.readInt();

					this.AddressLine1 = readString(dis);

					this.AddressLine2 = readString(dis);

					this.City = readString(dis);

					this.StateProvinceID = dis.readInt();

					this.PostalCode = readString(dis);

					this.SpatialLocation = readString(dis);

					this.rowguid = (Object) dis.readObject();

					this.ModifiedDate = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.AddressID);

				// String

				writeString(this.AddressLine1, dos);

				// String

				writeString(this.AddressLine2, dos);

				// String

				writeString(this.City, dos);

				// int

				dos.writeInt(this.StateProvinceID);

				// String

				writeString(this.PostalCode, dos);

				// String

				writeString(this.SpatialLocation, dos);

				// Object

				dos.writeObject(this.rowguid);

				// java.util.Date

				writeDate(this.ModifiedDate, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("AddressID=" + String.valueOf(AddressID));
			sb.append(",AddressLine1=" + AddressLine1);
			sb.append(",AddressLine2=" + AddressLine2);
			sb.append(",City=" + City);
			sb.append(",StateProvinceID=" + String.valueOf(StateProvinceID));
			sb.append(",PostalCode=" + PostalCode);
			sb.append(",SpatialLocation=" + SpatialLocation);
			sb.append(",rowguid=" + String.valueOf(rowguid));
			sb.append(",ModifiedDate=" + String.valueOf(ModifiedDate));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(AddressID);

			sb.append("|");

			if (AddressLine1 == null) {
				sb.append("<null>");
			} else {
				sb.append(AddressLine1);
			}

			sb.append("|");

			if (AddressLine2 == null) {
				sb.append("<null>");
			} else {
				sb.append(AddressLine2);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			sb.append(StateProvinceID);

			sb.append("|");

			if (PostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(PostalCode);
			}

			sb.append("|");

			if (SpatialLocation == null) {
				sb.append("<null>");
			} else {
				sb.append(SpatialLocation);
			}

			sb.append("|");

			if (rowguid == null) {
				sb.append("<null>");
			} else {
				sb.append(rowguid);
			}

			sb.append("|");

			if (ModifiedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(ModifiedDate);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OutStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.AddressID, other.AddressID);
			if (returnValue != 0) {
				return returnValue;
			}

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
		final static byte[] commonByteArrayLock_TRAINING_ReadDB = new byte[0];
		static byte[] commonByteArray_TRAINING_ReadDB = new byte[0];

		public int AddressID;

		public int getAddressID() {
			return this.AddressID;
		}

		public String AddressLine1;

		public String getAddressLine1() {
			return this.AddressLine1;
		}

		public String AddressLine2;

		public String getAddressLine2() {
			return this.AddressLine2;
		}

		public String City;

		public String getCity() {
			return this.City;
		}

		public int StateProvinceID;

		public int getStateProvinceID() {
			return this.StateProvinceID;
		}

		public String PostalCode;

		public String getPostalCode() {
			return this.PostalCode;
		}

		public String SpatialLocation;

		public String getSpatialLocation() {
			return this.SpatialLocation;
		}

		public Object rowguid;

		public Object getRowguid() {
			return this.rowguid;
		}

		public java.util.Date ModifiedDate;

		public java.util.Date getModifiedDate() {
			return this.ModifiedDate;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_ReadDB.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_ReadDB.length == 0) {
						commonByteArray_TRAINING_ReadDB = new byte[1024];
					} else {
						commonByteArray_TRAINING_ReadDB = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_ReadDB, 0, length);
				strReturn = new String(commonByteArray_TRAINING_ReadDB, 0,
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

		private java.util.Date readDate(ObjectInputStream dis)
				throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos)
				throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TRAINING_ReadDB) {

				try {

					int length = 0;

					this.AddressID = dis.readInt();

					this.AddressLine1 = readString(dis);

					this.AddressLine2 = readString(dis);

					this.City = readString(dis);

					this.StateProvinceID = dis.readInt();

					this.PostalCode = readString(dis);

					this.SpatialLocation = readString(dis);

					this.rowguid = (Object) dis.readObject();

					this.ModifiedDate = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.AddressID);

				// String

				writeString(this.AddressLine1, dos);

				// String

				writeString(this.AddressLine2, dos);

				// String

				writeString(this.City, dos);

				// int

				dos.writeInt(this.StateProvinceID);

				// String

				writeString(this.PostalCode, dos);

				// String

				writeString(this.SpatialLocation, dos);

				// Object

				dos.writeObject(this.rowguid);

				// java.util.Date

				writeDate(this.ModifiedDate, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("AddressID=" + String.valueOf(AddressID));
			sb.append(",AddressLine1=" + AddressLine1);
			sb.append(",AddressLine2=" + AddressLine2);
			sb.append(",City=" + City);
			sb.append(",StateProvinceID=" + String.valueOf(StateProvinceID));
			sb.append(",PostalCode=" + PostalCode);
			sb.append(",SpatialLocation=" + SpatialLocation);
			sb.append(",rowguid=" + String.valueOf(rowguid));
			sb.append(",ModifiedDate=" + String.valueOf(ModifiedDate));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(AddressID);

			sb.append("|");

			if (AddressLine1 == null) {
				sb.append("<null>");
			} else {
				sb.append(AddressLine1);
			}

			sb.append("|");

			if (AddressLine2 == null) {
				sb.append("<null>");
			} else {
				sb.append(AddressLine2);
			}

			sb.append("|");

			if (City == null) {
				sb.append("<null>");
			} else {
				sb.append(City);
			}

			sb.append("|");

			sb.append(StateProvinceID);

			sb.append("|");

			if (PostalCode == null) {
				sb.append("<null>");
			} else {
				sb.append(PostalCode);
			}

			sb.append("|");

			if (SpatialLocation == null) {
				sb.append("<null>");
			} else {
				sb.append(SpatialLocation);
			}

			sb.append("|");

			if (rowguid == null) {
				sb.append("<null>");
			} else {
				sb.append(rowguid);
			}

			sb.append("|");

			if (ModifiedDate == null) {
				sb.append("<null>");
			} else {
				sb.append(ModifiedDate);
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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap)
			throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception()
						.getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();
				OutStruct Out = new OutStruct();

				/**
				 * [tFileOutputDelimited_1 begin ] start
				 */

				ok_Hash.put("tFileOutputDelimited_1", false);
				start_Hash.put("tFileOutputDelimited_1",
						System.currentTimeMillis());

				currentComponent = "tFileOutputDelimited_1";

				int tos_count_tFileOutputDelimited_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileOutputDelimited_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileOutputDelimited_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileOutputDelimited_1 = new StringBuilder();
							log4jParamters_tFileOutputDelimited_1
									.append("Parameters:");
							log4jParamters_tFileOutputDelimited_1
									.append("USESTREAM" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("FILENAME"
											+ " = "
											+ "\"C:/Users/michael.quach/Documents/WorkSpace/DataSet/out.csv\"");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("FIELDSEPARATOR" + " = " + "\",\"");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("APPEND" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("INCLUDEHEADER" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("COMPRESS" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("ADVANCED_SEPARATOR" + " = "
											+ "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("CREATE" + " = " + "true");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("SPLIT" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("FLUSHONROW" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("ROW_MODE" + " = " + "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("ENCODING" + " = "
											+ "\"ISO-8859-15\"");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("DELETE_EMPTYFILE" + " = "
											+ "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							log4jParamters_tFileOutputDelimited_1
									.append("FILE_EXIST_EXCEPTION" + " = "
											+ "false");
							log4jParamters_tFileOutputDelimited_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileOutputDelimited_1 - "
										+ (log4jParamters_tFileOutputDelimited_1));
						}
					}
					new BytesLimit65535_tFileOutputDelimited_1()
							.limitLog4jByte();
				}

				String fileName_tFileOutputDelimited_1 = "";
				fileName_tFileOutputDelimited_1 = (new java.io.File(
						"C:/Users/michael.quach/Documents/WorkSpace/DataSet/out.csv"))
						.getAbsolutePath().replace("\\", "/");
				String fullName_tFileOutputDelimited_1 = null;
				String extension_tFileOutputDelimited_1 = null;
				String directory_tFileOutputDelimited_1 = null;
				if ((fileName_tFileOutputDelimited_1.indexOf("/") != -1)) {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") < fileName_tFileOutputDelimited_1
							.lastIndexOf("/")) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(0, fileName_tFileOutputDelimited_1
										.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1
										.lastIndexOf("."));
					}
					directory_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
							.substring(0, fileName_tFileOutputDelimited_1
									.lastIndexOf("/"));
				} else {
					if (fileName_tFileOutputDelimited_1.lastIndexOf(".") != -1) {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(0, fileName_tFileOutputDelimited_1
										.lastIndexOf("."));
						extension_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1
								.substring(fileName_tFileOutputDelimited_1
										.lastIndexOf("."));
					} else {
						fullName_tFileOutputDelimited_1 = fileName_tFileOutputDelimited_1;
						extension_tFileOutputDelimited_1 = "";
					}
					directory_tFileOutputDelimited_1 = "";
				}
				boolean isFileGenerated_tFileOutputDelimited_1 = true;
				java.io.File filetFileOutputDelimited_1 = new java.io.File(
						fileName_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME",
						fileName_tFileOutputDelimited_1);
				int nb_line_tFileOutputDelimited_1 = 0;
				int splitedFileNo_tFileOutputDelimited_1 = 0;
				int currentRow_tFileOutputDelimited_1 = 0;

				final String OUT_DELIM_tFileOutputDelimited_1 = /**
				 * Start field
				 * tFileOutputDelimited_1:FIELDSEPARATOR
				 */
				","/** End field tFileOutputDelimited_1:FIELDSEPARATOR */
				;

				final String OUT_DELIM_ROWSEP_tFileOutputDelimited_1 = /**
				 * Start
				 * field tFileOutputDelimited_1:ROWSEPARATOR
				 */
				"\n"/** End field tFileOutputDelimited_1:ROWSEPARATOR */
				;

				// create directory only if not exists
				if (directory_tFileOutputDelimited_1 != null
						&& directory_tFileOutputDelimited_1.trim().length() != 0) {
					java.io.File dir_tFileOutputDelimited_1 = new java.io.File(
							directory_tFileOutputDelimited_1);
					if (!dir_tFileOutputDelimited_1.exists()) {
						log.info("tFileOutputDelimited_1 - Creating directory '"
								+ dir_tFileOutputDelimited_1.getCanonicalPath()
								+ "'.");
						dir_tFileOutputDelimited_1.mkdirs();
						log.info("tFileOutputDelimited_1 - The directory '"
								+ dir_tFileOutputDelimited_1.getCanonicalPath()
								+ "' has been created successfully.");
					}
				}

				// routines.system.Row
				java.io.Writer outtFileOutputDelimited_1 = null;

				java.io.File fileToDelete_tFileOutputDelimited_1 = new java.io.File(
						fileName_tFileOutputDelimited_1);
				if (fileToDelete_tFileOutputDelimited_1.exists()) {
					fileToDelete_tFileOutputDelimited_1.delete();
				}
				outtFileOutputDelimited_1 = new java.io.BufferedWriter(
						new java.io.OutputStreamWriter(
								new java.io.FileOutputStream(
										fileName_tFileOutputDelimited_1, false),
								"ISO-8859-15"));

				resourceMap.put("out_tFileOutputDelimited_1",
						outtFileOutputDelimited_1);
				resourceMap.put("nb_line_tFileOutputDelimited_1",
						nb_line_tFileOutputDelimited_1);

				/**
				 * [tFileOutputDelimited_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = "
									+ "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1
									.append("TEMPORARY_DATA_DIRECTORY" + " = "
											+ "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE"
									+ " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1
									.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL"
											+ " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}

				// ###############################
				// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

				// ###############################

				// ###############################
				// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
				// ###############################

				// ###############################
				// # Outputs initialization
				int count_Out_tMap_1 = 0;

				OutStruct Out_tmp = new OutStruct();
				// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1
									.append("USE_EXISTING_CONNECTION" + " = "
											+ "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = "
									+ "context.AdventureWorks2016_Server");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DRIVER" + " = "
									+ "JTDS");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = "
									+ "context.AdventureWorks2016_Port");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DB_SCHEMA"
									+ " = "
									+ "context.AdventureWorks2016_Schema");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = "
									+ "context.AdventureWorks2016_Database");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = "
									+ "context.AdventureWorks2016_Login");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("PASS"
											+ " = "
											+ String.valueOf(
													routines.system.PasswordEncryptUtil
															.encryptPassword(context.AdventureWorks2016_Password))
													.substring(0, 4) + "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = "
									+ "\"Address\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE"
									+ " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("QUERY"
											+ " = "
											+ "\"SELECT [AddressID]        ,[AddressLine1]        ,[AddressLine2]        ,[City]        ,[StateProvinceID]        ,[PostalCode]        ,[SpatialLocation]        ,[rowguid]        ,[ModifiedDate]    FROM [Person].[Address]\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("SPECIFY_DATASOURCE_ALIAS" + " = "
											+ "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("PROPERTIES"
											+ " = "
											+ "context.AdventureWorks2016_AdditionalParams");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN"
									+ " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN"
									+ " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("AddressID")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("AddressLine1")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("AddressLine2")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("City")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("StateProvinceID")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("PostalCode")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("SpatialLocation")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("rowguid")
									+ "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("ModifiedDate")
									+ "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1
									.append("UNIFIED_COMPONENTS" + " = "
											+ "tMSSqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - "
										+ (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT",
						"NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1,
						talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = context.AdventureWorks2016_Login;

				final String decryptedPassword_tDBInput_1 = context.AdventureWorks2016_Password;

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = context.AdventureWorks2016_Port;
				String dbname_tDBInput_1 = context.AdventureWorks2016_Database;
				String url_tDBInput_1 = "jdbc:jtds:sqlserver://"
						+ context.AdventureWorks2016_Server;
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + context.AdventureWorks2016_Port;
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += "//"
							+ context.AdventureWorks2016_Database;
				}
				url_tDBInput_1 += ";appName=" + projectName + ";"
						+ context.AdventureWorks2016_AdditionalParams;
				String dbschema_tDBInput_1 = context.AdventureWorks2016_Schema;

				log.debug("tDBInput_1 - Driver ClassName: "
						+ driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '"
						+ url_tDBInput_1 + "' with the username '"
						+ dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(
						url_tDBInput_1, dbUser_tDBInput_1, dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1
						+ "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1
						.createStatement();

				String dbquery_tDBInput_1 = "SELECT [AddressID]\n      ,[AddressLine1]\n      ,[AddressLine2]\n      ,[City]\n      ,[StateProvinceID]\n      ,[Post"
						+ "alCode]\n      ,[SpatialLocation]\n      ,[rowguid]\n      ,[ModifiedDate]\n  FROM [Person].[Address]";

				log.debug("tDBInput_1 - Executing the query: '"
						+ dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1
							.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1
							.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1
							.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.AddressID = 0;
						} else {

							if (rs_tDBInput_1.getObject(1) != null) {
								row1.AddressID = rs_tDBInput_1.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.AddressLine1 = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(2)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									row1.AddressLine1 = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.AddressLine1 = tmpContent_tDBInput_1;
								}
							} else {
								row1.AddressLine1 = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.AddressLine2 = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(3)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									row1.AddressLine2 = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.AddressLine2 = tmpContent_tDBInput_1;
								}
							} else {
								row1.AddressLine2 = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.City = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(4)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									row1.City = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.City = tmpContent_tDBInput_1;
								}
							} else {
								row1.City = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.StateProvinceID = 0;
						} else {

							if (rs_tDBInput_1.getObject(5) != null) {
								row1.StateProvinceID = rs_tDBInput_1.getInt(5);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.PostalCode = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(6)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									row1.PostalCode = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.PostalCode = tmpContent_tDBInput_1;
								}
							} else {
								row1.PostalCode = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row1.SpatialLocation = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(7)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									row1.SpatialLocation = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.SpatialLocation = tmpContent_tDBInput_1;
								}
							} else {
								row1.SpatialLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row1.rowguid = null;
						} else {

							if (rs_tDBInput_1.getObject(8) != null) {
								row1.rowguid = rs_tDBInput_1.getObject(8);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row1.ModifiedDate = null;
						} else {

							row1.ModifiedDate = mssqlGTU_tDBInput_1.getDate(
									rsmd_tDBInput_1, rs_tDBInput_1, 9);

						}

						log.debug("tDBInput_1 - Retrieving the record "
								+ nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (log.isTraceEnabled()) {
							log.trace("row1 - "
									+ (row1 == null ? "" : row1.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							Out = null;

							// # Output table : 'Out'
							count_Out_tMap_1++;

							Out_tmp.AddressID = row1.AddressID;
							Out_tmp.AddressLine1 = row1.AddressLine1;
							Out_tmp.AddressLine2 = row1.AddressLine2;
							Out_tmp.City = row1.City;
							Out_tmp.StateProvinceID = row1.StateProvinceID;
							Out_tmp.PostalCode = row1.PostalCode;
							Out_tmp.SpatialLocation = row1.SpatialLocation;
							Out_tmp.rowguid = row1.rowguid;
							Out_tmp.ModifiedDate = row1.ModifiedDate;
							Out = Out_tmp;
							log.debug("tMap_1 - Outputting the record "
									+ count_Out_tMap_1
									+ " of the output table 'Out'.");

							// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
						// Start of branch "Out"
						if (Out != null) {

							/**
							 * [tFileOutputDelimited_1 main ] start
							 */

							currentComponent = "tFileOutputDelimited_1";

							if (log.isTraceEnabled()) {
								log.trace("Out - "
										+ (Out == null ? "" : Out.toLogString()));
							}

							StringBuilder sb_tFileOutputDelimited_1 = new StringBuilder();
							sb_tFileOutputDelimited_1.append(Out.AddressID);
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.AddressLine1 != null) {
								sb_tFileOutputDelimited_1
										.append(Out.AddressLine1);
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.AddressLine2 != null) {
								sb_tFileOutputDelimited_1
										.append(Out.AddressLine2);
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.City != null) {
								sb_tFileOutputDelimited_1.append(Out.City);
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							sb_tFileOutputDelimited_1
									.append(Out.StateProvinceID);
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.PostalCode != null) {
								sb_tFileOutputDelimited_1
										.append(Out.PostalCode);
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.SpatialLocation != null) {
								sb_tFileOutputDelimited_1
										.append(Out.SpatialLocation);
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.rowguid != null) {
								sb_tFileOutputDelimited_1.append(Out.rowguid);
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_tFileOutputDelimited_1);
							if (Out.ModifiedDate != null) {
								sb_tFileOutputDelimited_1.append(FormatterUtils
										.format_Date(Out.ModifiedDate,
												"dd-MM-yyyy"));
							}
							sb_tFileOutputDelimited_1
									.append(OUT_DELIM_ROWSEP_tFileOutputDelimited_1);

							nb_line_tFileOutputDelimited_1++;
							resourceMap.put("nb_line_tFileOutputDelimited_1",
									nb_line_tFileOutputDelimited_1);

							outtFileOutputDelimited_1
									.write(sb_tFileOutputDelimited_1.toString());
							log.debug("tFileOutputDelimited_1 - Writing the record "
									+ nb_line_tFileOutputDelimited_1 + ".");

							tos_count_tFileOutputDelimited_1++;

							/**
							 * [tFileOutputDelimited_1 main ] stop
							 */

							/**
							 * [tFileOutputDelimited_1 process_data_begin ]
							 * start
							 */

							currentComponent = "tFileOutputDelimited_1";

							/**
							 * [tFileOutputDelimited_1 process_data_begin ] stop
							 */

							/**
							 * [tFileOutputDelimited_1 process_data_end ] start
							 */

							currentComponent = "tFileOutputDelimited_1";

							/**
							 * [tFileOutputDelimited_1 process_data_end ] stop
							 */

						} // End of branch "Out"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						log.debug("tDBInput_1 - Connection to the database closed.");

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: "
						+ nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

				// ###############################
				// # Lookup hashes releasing
				// ###############################
				log.debug("tMap_1 - Written records count in the table 'Out': "
						+ count_Out_tMap_1 + ".");

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 end ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (outtFileOutputDelimited_1 != null) {
					outtFileOutputDelimited_1.flush();
					outtFileOutputDelimited_1.close();
				}

				globalMap.put("tFileOutputDelimited_1_NB_LINE",
						nb_line_tFileOutputDelimited_1);
				globalMap.put("tFileOutputDelimited_1_FILE_NAME",
						fileName_tFileOutputDelimited_1);

				resourceMap.put("finish_tFileOutputDelimited_1", true);

				log.debug("tFileOutputDelimited_1 - Written records count: "
						+ nb_line_tFileOutputDelimited_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tFileOutputDelimited_1 - " + ("Done."));

				ok_Hash.put("tFileOutputDelimited_1", true);
				end_Hash.put("tFileOutputDelimited_1",
						System.currentTimeMillis());

				/**
				 * [tFileOutputDelimited_1 end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent,
					globalMap);

			throw te;
		} catch (java.lang.Error error) {

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tFileOutputDelimited_1 finally ] start
				 */

				currentComponent = "tFileOutputDelimited_1";

				if (resourceMap.get("finish_tFileOutputDelimited_1") == null) {

					java.io.Writer outtFileOutputDelimited_1 = (java.io.Writer) resourceMap
							.get("out_tFileOutputDelimited_1");
					if (outtFileOutputDelimited_1 != null) {
						outtFileOutputDelimited_1.flush();
						outtFileOutputDelimited_1.close();
					}

				}

				/**
				 * [tFileOutputDelimited_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
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
		final ReadDB ReadDBClass = new ReadDB();

		int exitCode = ReadDBClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'ReadDB' - Done.");
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
		log.info("TalendJob: 'ReadDB' - Start.");

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

		try {
			// call job/subjob with an existing context, like:
			// --context=production. if without this parameter, there will use
			// the default context instead.
			java.io.InputStream inContext = ReadDB.class.getClassLoader()
					.getResourceAsStream(
							"training/readdb_0_1/contexts/" + contextStr
									+ ".properties");
			if (inContext == null) {
				inContext = ReadDB.class.getClassLoader().getResourceAsStream(
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
			context.setContextType("AdventureWorks2016_Schema", "id_String");

			context.AdventureWorks2016_Schema = (String) context
					.getProperty("AdventureWorks2016_Schema");
			context.setContextType("AdventureWorks2016_Database", "id_String");

			context.AdventureWorks2016_Database = (String) context
					.getProperty("AdventureWorks2016_Database");
			context.setContextType("AdventureWorks2016_Login", "id_String");

			context.AdventureWorks2016_Login = (String) context
					.getProperty("AdventureWorks2016_Login");
			context.setContextType("AdventureWorks2016_Password", "id_Password");

			String pwd_AdventureWorks2016_Password_value = context
					.getProperty("AdventureWorks2016_Password");
			context.AdventureWorks2016_Password = null;
			if (pwd_AdventureWorks2016_Password_value != null) {
				if (context_param.containsKey("AdventureWorks2016_Password")) {// no
																				// need
																				// to
																				// decrypt
																				// if
																				// it
																				// come
																				// from
																				// program
																				// argument
																				// or
																				// parent
																				// job
																				// runtime
					context.AdventureWorks2016_Password = pwd_AdventureWorks2016_Password_value;
				} else if (!pwd_AdventureWorks2016_Password_value.isEmpty()) {
					try {
						context.AdventureWorks2016_Password = routines.system.PasswordEncryptUtil
								.decryptPassword(pwd_AdventureWorks2016_Password_value);
						context.put("AdventureWorks2016_Password",
								context.AdventureWorks2016_Password);
					} catch (java.lang.RuntimeException e) {
						// do nothing
					}
				}
			}
			context.setContextType("AdventureWorks2016_AdditionalParams",
					"id_String");

			context.AdventureWorks2016_AdditionalParams = (String) context
					.getProperty("AdventureWorks2016_AdditionalParams");
			context.setContextType("AdventureWorks2016_Server", "id_String");

			context.AdventureWorks2016_Server = (String) context
					.getProperty("AdventureWorks2016_Server");
			context.setContextType("AdventureWorks2016_Port", "id_String");

			context.AdventureWorks2016_Port = (String) context
					.getProperty("AdventureWorks2016_Port");
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("AdventureWorks2016_Schema")) {
				context.AdventureWorks2016_Schema = (String) parentContextMap
						.get("AdventureWorks2016_Schema");
			}
			if (parentContextMap.containsKey("AdventureWorks2016_Database")) {
				context.AdventureWorks2016_Database = (String) parentContextMap
						.get("AdventureWorks2016_Database");
			}
			if (parentContextMap.containsKey("AdventureWorks2016_Login")) {
				context.AdventureWorks2016_Login = (String) parentContextMap
						.get("AdventureWorks2016_Login");
			}
			if (parentContextMap.containsKey("AdventureWorks2016_Password")) {
				context.AdventureWorks2016_Password = (java.lang.String) parentContextMap
						.get("AdventureWorks2016_Password");
			}
			if (parentContextMap
					.containsKey("AdventureWorks2016_AdditionalParams")) {
				context.AdventureWorks2016_AdditionalParams = (String) parentContextMap
						.get("AdventureWorks2016_AdditionalParams");
			}
			if (parentContextMap.containsKey("AdventureWorks2016_Server")) {
				context.AdventureWorks2016_Server = (String) parentContextMap
						.get("AdventureWorks2016_Server");
			}
			if (parentContextMap.containsKey("AdventureWorks2016_Port")) {
				context.AdventureWorks2016_Port = (String) parentContextMap
						.get("AdventureWorks2016_Port");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil
				.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName,
				jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("AdventureWorks2016_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName,
				parent_part_launcher, Thread.currentThread().getId() + "", "",
				"", "", "",
				resumeUtil.convertToJsonText(context, parametersToEncrypt));

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
			tDBInput_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_1) {
			globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

			e_tDBInput_1.printStackTrace();

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
					+ " bytes memory increase when running : ReadDB");
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
 * 78453 characters generated by Talend Data Fabric on the December 14, 2018
 * 4:55:13 PM EST
 ************************************************************************************************/
