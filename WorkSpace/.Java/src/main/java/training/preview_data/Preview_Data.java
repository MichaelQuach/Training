package training.preview_data;

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
 * Job: Preview_Data Purpose: <br>
 * Description:  <br>
 * @author 
 * @version 7.1.1.20181026_1147
 * @status 
 */
public class Preview_Data implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

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

	private final String jobVersion = "null";
	private final String jobName = "Preview_Data";
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
					Preview_Data.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass()
							.getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Preview_Data.this, new Object[] { e,
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

	public void tJavaRow_gen_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSocketOutput_gen_error(Exception exception,
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

	public static class rowDataFromtJavaRow_genStruct implements
			routines.system.IPersistableRow<rowDataFromtJavaRow_genStruct> {
		final static byte[] commonByteArrayLock_TRAINING_Preview_Data = new byte[0];
		static byte[] commonByteArray_TRAINING_Preview_Data = new byte[0];
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
			final rowDataFromtJavaRow_genStruct other = (rowDataFromtJavaRow_genStruct) obj;

			if (this.AddressID != other.AddressID)
				return false;

			return true;
		}

		public void copyDataTo(rowDataFromtJavaRow_genStruct other) {

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

		public void copyKeysDataTo(rowDataFromtJavaRow_genStruct other) {

			other.AddressID = this.AddressID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_Preview_Data.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_Preview_Data.length == 0) {
						commonByteArray_TRAINING_Preview_Data = new byte[1024];
					} else {
						commonByteArray_TRAINING_Preview_Data = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_Preview_Data, 0, length);
				strReturn = new String(commonByteArray_TRAINING_Preview_Data,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TRAINING_Preview_Data) {

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

		/**
		 * Compare keys
		 */
		public int compareTo(rowDataFromtJavaRow_genStruct other) {

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

	public static class rowDataFromtDBInput_1Struct implements
			routines.system.IPersistableRow<rowDataFromtDBInput_1Struct> {
		final static byte[] commonByteArrayLock_TRAINING_Preview_Data = new byte[0];
		static byte[] commonByteArray_TRAINING_Preview_Data = new byte[0];
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
			final rowDataFromtDBInput_1Struct other = (rowDataFromtDBInput_1Struct) obj;

			if (this.AddressID != other.AddressID)
				return false;

			return true;
		}

		public void copyDataTo(rowDataFromtDBInput_1Struct other) {

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

		public void copyKeysDataTo(rowDataFromtDBInput_1Struct other) {

			other.AddressID = this.AddressID;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TRAINING_Preview_Data.length) {
					if (length < 1024
							&& commonByteArray_TRAINING_Preview_Data.length == 0) {
						commonByteArray_TRAINING_Preview_Data = new byte[1024];
					} else {
						commonByteArray_TRAINING_Preview_Data = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TRAINING_Preview_Data, 0, length);
				strReturn = new String(commonByteArray_TRAINING_Preview_Data,
						0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_TRAINING_Preview_Data) {

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

		/**
		 * Compare keys
		 */
		public int compareTo(rowDataFromtDBInput_1Struct other) {

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

				rowDataFromtDBInput_1Struct rowDataFromtDBInput_1 = new rowDataFromtDBInput_1Struct();
				rowDataFromtJavaRow_genStruct rowDataFromtJavaRow_gen = new rowDataFromtJavaRow_genStruct();

				/**
				 * [tSocketOutput_gen begin ] start
				 */

				ok_Hash.put("tSocketOutput_gen", false);
				start_Hash.put("tSocketOutput_gen", System.currentTimeMillis());

				currentComponent = "tSocketOutput_gen";

				int tos_count_tSocketOutput_gen = 0;

				java.net.Socket sockettSocketOutput_gen = null;
				int nb_line_tSocketOutput_gen = 0;
				boolean retrytSocketOutput_gen = true;
				java.net.ConnectException exception_tSocketOutput_gen = null;

				for (int i = 0; i < 10 - 1; i++) {
					if (retrytSocketOutput_gen) {
						try {
							sockettSocketOutput_gen = new java.net.Socket(
									"127.0.0.1", 44716);
							retrytSocketOutput_gen = false;
						} catch (java.net.ConnectException etSocketOutput_gen) {
							exception_tSocketOutput_gen = etSocketOutput_gen;
							Thread.sleep(1000);
						}
					}
				}

				if (retrytSocketOutput_gen
						&& (exception_tSocketOutput_gen != null)) {
					throw exception_tSocketOutput_gen;
				}

				com.talend.csv.CSVWriter CsvWritertSocketOutput_gen = new com.talend.csv.CSVWriter(
						new java.io.BufferedWriter(
								new java.io.OutputStreamWriter(
										sockettSocketOutput_gen
												.getOutputStream(), "UTF-8")));
				CsvWritertSocketOutput_gen.setSeparator(';');

				/**
				 * [tSocketOutput_gen begin ] stop
				 */

				/**
				 * [tJavaRow_gen begin ] start
				 */

				ok_Hash.put("tJavaRow_gen", false);
				start_Hash.put("tJavaRow_gen", System.currentTimeMillis());

				currentComponent = "tJavaRow_gen";

				int tos_count_tJavaRow_gen = 0;

				int nb_line_tJavaRow_gen = 0;

				/**
				 * [tJavaRow_gen begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

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

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(
						url_tDBInput_1, dbUser_tDBInput_1, dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1
						.createStatement();

				String dbquery_tDBInput_1 = "SELECT [AddressID]\n      ,[AddressLine1]\n      ,[AddressLine2]\n      ,[City]\n      ,[StateProvinceID]\n      ,[Post"
						+ "alCode]\n      ,[SpatialLocation]\n      ,[rowguid]\n      ,[ModifiedDate]\n  FROM [Person].[Address]";

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

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							rowDataFromtDBInput_1.AddressID = 0;
						} else {

							if (rs_tDBInput_1.getObject(1) != null) {
								rowDataFromtDBInput_1.AddressID = rs_tDBInput_1
										.getInt(1);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							rowDataFromtDBInput_1.AddressLine1 = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(2)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									rowDataFromtDBInput_1.AddressLine1 = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									rowDataFromtDBInput_1.AddressLine1 = tmpContent_tDBInput_1;
								}
							} else {
								rowDataFromtDBInput_1.AddressLine1 = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							rowDataFromtDBInput_1.AddressLine2 = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(3)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									rowDataFromtDBInput_1.AddressLine2 = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									rowDataFromtDBInput_1.AddressLine2 = tmpContent_tDBInput_1;
								}
							} else {
								rowDataFromtDBInput_1.AddressLine2 = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							rowDataFromtDBInput_1.City = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(4)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									rowDataFromtDBInput_1.City = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									rowDataFromtDBInput_1.City = tmpContent_tDBInput_1;
								}
							} else {
								rowDataFromtDBInput_1.City = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							rowDataFromtDBInput_1.StateProvinceID = 0;
						} else {

							if (rs_tDBInput_1.getObject(5) != null) {
								rowDataFromtDBInput_1.StateProvinceID = rs_tDBInput_1
										.getInt(5);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							rowDataFromtDBInput_1.PostalCode = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(6)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									rowDataFromtDBInput_1.PostalCode = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									rowDataFromtDBInput_1.PostalCode = tmpContent_tDBInput_1;
								}
							} else {
								rowDataFromtDBInput_1.PostalCode = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							rowDataFromtDBInput_1.SpatialLocation = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1
										.contains(rsmd_tDBInput_1
												.getColumnTypeName(7)
												.toUpperCase(
														java.util.Locale.ENGLISH))) {
									rowDataFromtDBInput_1.SpatialLocation = FormatterUtils
											.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									rowDataFromtDBInput_1.SpatialLocation = tmpContent_tDBInput_1;
								}
							} else {
								rowDataFromtDBInput_1.SpatialLocation = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 8) {
							rowDataFromtDBInput_1.rowguid = null;
						} else {

							if (rs_tDBInput_1.getObject(8) != null) {
								rowDataFromtDBInput_1.rowguid = rs_tDBInput_1
										.getObject(8);
							} else {
								throw new RuntimeException(
										"Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							rowDataFromtDBInput_1.ModifiedDate = null;
						} else {

							rowDataFromtDBInput_1.ModifiedDate = mssqlGTU_tDBInput_1
									.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 9);

						}

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
						 * [tJavaRow_gen main ] start
						 */

						currentComponent = "tJavaRow_gen";

						rowDataFromtJavaRow_gen.AddressID = rowDataFromtDBInput_1.AddressID;
						rowDataFromtJavaRow_gen.AddressLine1 = rowDataFromtDBInput_1.AddressLine1;
						rowDataFromtJavaRow_gen.AddressLine2 = rowDataFromtDBInput_1.AddressLine2;
						rowDataFromtJavaRow_gen.City = rowDataFromtDBInput_1.City;
						rowDataFromtJavaRow_gen.StateProvinceID = rowDataFromtDBInput_1.StateProvinceID;
						rowDataFromtJavaRow_gen.PostalCode = rowDataFromtDBInput_1.PostalCode;
						rowDataFromtJavaRow_gen.SpatialLocation = rowDataFromtDBInput_1.SpatialLocation;
						rowDataFromtJavaRow_gen.rowguid = rowDataFromtDBInput_1.rowguid;
						rowDataFromtJavaRow_gen.ModifiedDate = rowDataFromtDBInput_1.ModifiedDate;

						if (nb_line_tJavaRow_gen >= 1000) {
							break;
						}

						nb_line_tJavaRow_gen++;

						tos_count_tJavaRow_gen++;

						/**
						 * [tJavaRow_gen main ] stop
						 */

						/**
						 * [tJavaRow_gen process_data_begin ] start
						 */

						currentComponent = "tJavaRow_gen";

						/**
						 * [tJavaRow_gen process_data_begin ] stop
						 */

						/**
						 * [tSocketOutput_gen main ] start
						 */

						currentComponent = "tSocketOutput_gen";

						CsvWritertSocketOutput_gen.setEscapeChar('\\');

						CsvWritertSocketOutput_gen.setQuoteChar('"');
						CsvWritertSocketOutput_gen
								.setQuoteStatus(com.talend.csv.CSVWriter.QuoteStatus.FORCE);
						String[] rowtSocketOutput_gen = new String[9];
						rowtSocketOutput_gen[0] = String
								.valueOf(rowDataFromtJavaRow_gen.AddressID);
						if (rowDataFromtJavaRow_gen.AddressLine1 == null) {
							rowtSocketOutput_gen[1] = "";
						} else {
							rowtSocketOutput_gen[1] = rowDataFromtJavaRow_gen.AddressLine1;
						}
						if (rowDataFromtJavaRow_gen.AddressLine2 == null) {
							rowtSocketOutput_gen[2] = "";
						} else {
							rowtSocketOutput_gen[2] = rowDataFromtJavaRow_gen.AddressLine2;
						}
						if (rowDataFromtJavaRow_gen.City == null) {
							rowtSocketOutput_gen[3] = "";
						} else {
							rowtSocketOutput_gen[3] = rowDataFromtJavaRow_gen.City;
						}
						rowtSocketOutput_gen[4] = String
								.valueOf(rowDataFromtJavaRow_gen.StateProvinceID);
						if (rowDataFromtJavaRow_gen.PostalCode == null) {
							rowtSocketOutput_gen[5] = "";
						} else {
							rowtSocketOutput_gen[5] = rowDataFromtJavaRow_gen.PostalCode;
						}
						if (rowDataFromtJavaRow_gen.SpatialLocation == null) {
							rowtSocketOutput_gen[6] = "";
						} else {
							rowtSocketOutput_gen[6] = rowDataFromtJavaRow_gen.SpatialLocation;
						}
						if (rowDataFromtJavaRow_gen.rowguid == null) {
							rowtSocketOutput_gen[7] = "";
						} else {
							rowtSocketOutput_gen[7] = String
									.valueOf(rowDataFromtJavaRow_gen.rowguid);
						}
						if (rowDataFromtJavaRow_gen.ModifiedDate == null) {
							rowtSocketOutput_gen[8] = "";
						} else {
							rowtSocketOutput_gen[8] = FormatterUtils
									.format_Date(
											rowDataFromtJavaRow_gen.ModifiedDate,
											"dd-MM-yyyy");
						}
						CsvWritertSocketOutput_gen
								.writeNext(rowtSocketOutput_gen);
						CsvWritertSocketOutput_gen.flush();

						nb_line_tSocketOutput_gen++;

						tos_count_tSocketOutput_gen++;

						/**
						 * [tSocketOutput_gen main ] stop
						 */

						/**
						 * [tSocketOutput_gen process_data_begin ] start
						 */

						currentComponent = "tSocketOutput_gen";

						/**
						 * [tSocketOutput_gen process_data_begin ] stop
						 */

						/**
						 * [tSocketOutput_gen process_data_end ] start
						 */

						currentComponent = "tSocketOutput_gen";

						/**
						 * [tSocketOutput_gen process_data_end ] stop
						 */

						/**
						 * [tJavaRow_gen process_data_end ] start
						 */

						currentComponent = "tJavaRow_gen";

						/**
						 * [tJavaRow_gen process_data_end ] stop
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

						conn_tDBInput_1.close();

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tJavaRow_gen end ] start
				 */

				currentComponent = "tJavaRow_gen";

				globalMap.put("tJavaRow_gen_NB_LINE", nb_line_tJavaRow_gen);

				ok_Hash.put("tJavaRow_gen", true);
				end_Hash.put("tJavaRow_gen", System.currentTimeMillis());

				/**
				 * [tJavaRow_gen end ] stop
				 */

				/**
				 * [tSocketOutput_gen end ] start
				 */

				currentComponent = "tSocketOutput_gen";

				if (sockettSocketOutput_gen != null) {
					sockettSocketOutput_gen.close();
				}

				if (CsvWritertSocketOutput_gen != null) {
					CsvWritertSocketOutput_gen.close();
				}

				globalMap.put("tSocketOutput_gen_NB_LINE",
						nb_line_tSocketOutput_gen);

				ok_Hash.put("tSocketOutput_gen", true);
				end_Hash.put("tSocketOutput_gen", System.currentTimeMillis());

				/**
				 * [tSocketOutput_gen end ] stop
				 */

			}// end the resume

		} catch (java.lang.Exception e) {

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
				 * [tJavaRow_gen finally ] start
				 */

				currentComponent = "tJavaRow_gen";

				/**
				 * [tJavaRow_gen finally ] stop
				 */

				/**
				 * [tSocketOutput_gen finally ] start
				 */

				currentComponent = "tSocketOutput_gen";

				/**
				 * [tSocketOutput_gen finally ] stop
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
		final Preview_Data Preview_DataClass = new Preview_Data();

		int exitCode = Preview_DataClass.runJobInTOS(args);

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
			java.io.InputStream inContext = Preview_Data.class.getClassLoader()
					.getResourceAsStream(
							"training/preview_data/contexts/" + contextStr
									+ ".properties");
			if (inContext == null) {
				inContext = Preview_Data.class
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
					+ " bytes memory increase when running : Preview_Data");
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
 * 60377 characters generated by Talend Data Fabric on the December 14, 2018
 * 10:03:50 AM EST
 ************************************************************************************************/
