package org.talend.designer.codegen.translators.logs_errors;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import java.util.List;
import java.util.Map;

public class TLogRowBeginJava
{
  protected static String nl;
  public static synchronized TLogRowBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TLogRowBeginJava result = new TLogRowBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t///////////////////////" + NL + "\t";
  protected final String TEXT_3 = NL + "        ";
  protected final String TEXT_4 = " class Util_";
  protected final String TEXT_5 = " {" + NL + "" + NL + "        String[] des_top = { \".\", \".\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_head = { \"|=\", \"=|\", \"-\", \"+\" };" + NL + "" + NL + "        String[] des_bottom = { \"'\", \"'\", \"-\", \"+\" };" + NL + "" + NL + "        String name=\"\";" + NL + "" + NL + "        java.util.List<String[]> list = new java.util.ArrayList<String[]>();" + NL + "" + NL + "        int[] colLengths = new int[";
  protected final String TEXT_6 = "];" + NL + "" + NL + "        public void addRow(String[] row) {" + NL + "" + NL + "            for (int i = 0; i < ";
  protected final String TEXT_7 = "; i++) {" + NL + "                if (row[i]!=null) {" + NL + "                  colLengths[i] = Math.max(colLengths[i], row[i].length());" + NL + "                }" + NL + "            }" + NL + "            list.add(row);" + NL + "        }" + NL + "" + NL + "        public void setTableName(String name) {" + NL + "" + NL + "            this.name = name;" + NL + "        }" + NL + "" + NL + "            public StringBuilder format() {" + NL + "            " + NL + "                StringBuilder sb = new StringBuilder();" + NL + " ";
  protected final String TEXT_8 = " " + NL + "            " + NL + "                    sb.append(print(des_top));" + NL + "    " + NL + "                    int totals = 0;" + NL + "                    for (int i = 0; i < colLengths.length; i++) {" + NL + "                        totals = totals + colLengths[i];" + NL + "                    }" + NL + "    " + NL + "                    // name" + NL + "                    sb.append(\"|\");" + NL + "                    int k = 0;" + NL + "                    for (k = 0; k < (totals + ";
  protected final String TEXT_9 = " - name.length()) / 2; k++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(name);" + NL + "                    for (int i = 0; i < totals + ";
  protected final String TEXT_10 = " - name.length() - k; i++) {" + NL + "                        sb.append(' ');" + NL + "                    }" + NL + "                    sb.append(\"|\\n\");" + NL + "" + NL + "                    // head and rows" + NL + "                    sb.append(print(des_head));" + NL + "                    for (int i = 0; i < list.size(); i++) {" + NL + "    " + NL + "                        String[] row = list.get(i);" + NL + "    " + NL + "                        java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());" + NL + "                        " + NL + "                        StringBuilder sbformat = new StringBuilder();                                       ";
  protected final String TEXT_11 = "      " + NL + "        \t\t\t        sbformat.append(\"|%";
  protected final String TEXT_12 = "$-\");" + NL + "        \t\t\t        sbformat.append(colLengths[";
  protected final String TEXT_13 = "]);" + NL + "        \t\t\t        sbformat.append(\"s\");" + NL + "        \t\t\t        ";
  protected final String TEXT_14 = "              " + NL + "                        sbformat.append(\"|\\n\");                    " + NL + "       " + NL + "                        formatter.format(sbformat.toString(), (Object[])row);\t" + NL + "                                " + NL + "                        sb.append(formatter.toString());" + NL + "                        if (i == 0)" + NL + "                            sb.append(print(des_head)); // print the head" + NL + "                    }" + NL + "    " + NL + "                    // end" + NL + "                    sb.append(print(des_bottom));" + NL + "                    return sb;" + NL + "                }" + NL + "            " + NL + "" + NL + "            private StringBuilder print(String[] fillChars) {" + NL + "                StringBuilder sb = new StringBuilder();" + NL + "                //first column" + NL + "                sb.append(fillChars[0]);";
  protected final String TEXT_15 = "                " + NL + "                    for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_16 = "\t                " + NL;
  protected final String TEXT_17 = NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_18 = "] - fillChars[3].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }" + NL + "                    sb.append(fillChars[3]);";
  protected final String TEXT_19 = NL + "                ";
  protected final String TEXT_20 = "  " + NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_21 = "] - fillChars[0].length() - fillChars[1].length()+2; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_22 = NL + "                    //last column" + NL + "                    for (int i = 0; i < colLengths[";
  protected final String TEXT_23 = "] - fillChars[1].length() + 1; i++) {" + NL + "                        sb.append(fillChars[2]);" + NL + "                    }";
  protected final String TEXT_24 = "         " + NL + "                sb.append(fillChars[1]);" + NL + "                sb.append(\"\\n\");";
  protected final String TEXT_25 = "               " + NL + "                return sb;" + NL + "            }" + NL + "            " + NL + "            public boolean isTableEmpty(){" + NL + "            \tif (list.size() > 1)" + NL + "            \t\treturn false;" + NL + "            \treturn true;" + NL + "            }" + NL + "        }" + NL + "        Util_";
  protected final String TEXT_26 = " util_";
  protected final String TEXT_27 = " = new Util_";
  protected final String TEXT_28 = "();" + NL + "        util_";
  protected final String TEXT_29 = ".setTableName(\"";
  protected final String TEXT_30 = "\");" + NL + "        util_";
  protected final String TEXT_31 = ".addRow(new String[]{";
  protected final String TEXT_32 = "\"";
  protected final String TEXT_33 = "\",";
  protected final String TEXT_34 = "});        ";
  protected final String TEXT_35 = "\t" + NL + "" + NL + "" + NL + "\tclass Util_";
  protected final String TEXT_36 = " {" + NL + "\t" + NL + "\t\tString[] des_top = { \".\", \"-\" };" + NL + "" + NL + "        String[] des_data = { \"-\", \"+\" };" + NL + "" + NL + "        String[] des_frame = { \"|\" }; " + NL + "        " + NL + "        public void printLine(StringBuilder sb, int titleWidth, int dataWidth){" + NL + "        " + NL + "        \tsb.append(\"+\");" + NL + "\t\t\tfor(int i=0; i<titleWidth+2; i++)" + NL + "\t\t\t\tsb.append(\"-\");" + NL + "\t\t\tsb.append(\"+\");" + NL + "\t\t\tfor(int i=0; i<dataWidth+2; i++)" + NL + "\t\t\t\tsb.append(\"-\");" + NL + "        \tsb.append(\"+\" + \"\\n\");" + NL + "        }      " + NL + "" + NL + "\t\tpublic String print(String[] row, int nbLine){" + NL + "\t\t\t" + NL + "\t\t\tStringBuilder sb = new StringBuilder();" + NL + "\t\t\t";
  protected final String TEXT_37 = NL + "\t\t\t    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_38 = "\";" + NL + "\t\t\t    ";
  protected final String TEXT_39 = NL + "\t\t\t    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_40 = "\";" + NL + "\t\t\t    ";
  protected final String TEXT_41 = NL + "\t\t\t    String title = \"#\" + nbLine + \". \" + \"";
  protected final String TEXT_42 = "--";
  protected final String TEXT_43 = "\";" + NL + "\t\t\t    ";
  protected final String TEXT_44 = NL + "\t\t" + NL + "\t\t\t//step 1: get the max length of all the row[] member;" + NL + "\t\t\tint dataWidth = 5;\t\t//the length of the string \"value\"\t" + NL + "\t\t\tfor(int i=0;i<row.length;i++) {" + NL + "\t\t\t\tif(row[i] == null && 4 > dataWidth) {" + NL + "\t\t\t\t\tdataWidth = 4;" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse if(row[i] != null && row[i].length()>dataWidth) " + NL + "\t\t\t\t\tdataWidth = row[i].length();" + NL + "\t\t\t}\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_45 = "\t\t\t" + NL + "\t\t\tint titleWidth = ";
  protected final String TEXT_46 = ";" + NL + "\t\t\t" + NL + "\t\t\tint totalWidth = dataWidth + titleWidth + 5;" + NL + "\t\t\t" + NL + "\t\t\t//step 2: print the header with line number" + NL + "\t\t\tsb.append(\".\");" + NL + "\t\t\tfor(int i=0 ; i<totalWidth ; i++)" + NL + "\t\t\t\tsb.append(\"-\");\t\t\t" + NL + "\t\t\tsb.append(\".\" + \"\\n\" + \"|\");" + NL + "\t\t\t" + NL + "\t\t\tint emptyCenterWidth = (totalWidth-title.length())/2;" + NL + "\t\t\tfor(int i=0 ; i<emptyCenterWidth; i++)" + NL + "\t\t\t\tsb.append(\" \");\t" + NL + "\t\t\tsb.append(title);" + NL + "\t\t\tfor(int i=0 ; i<totalWidth - emptyCenterWidth - title.length() ; i++)" + NL + "\t\t\t\tsb.append(\" \");\t" + NL + "\t\t\tsb.append(\"|\" + \"\\n\");" + NL + "\t\t\t" + NL + "\t\t\t//step 3: print \"key\" and \"value\"\t\t\t" + NL + "\t\t\tprintLine(sb,titleWidth,dataWidth);" + NL + "\t\t\t" + NL + "\t\t\tsb.append(\"|\" + \" key\");" + NL + "\t\t\tfor(int i=0; i<titleWidth-2; i++)" + NL + "\t\t\t\tsb.append(\" \");" + NL + "        \tsb.append(\"|\" + \" value\");" + NL + "\t\t\tfor(int i=0; i<dataWidth-4; i++)" + NL + "\t\t\t\tsb.append(\" \");" + NL + "\t\t\tsb.append(\"|\" + \"\\n\");" + NL + "\t\t\t" + NL + "\t\t\tprintLine(sb,titleWidth,dataWidth);" + NL + "\t\t\t" + NL + "\t\t\t//step 4: print dataset" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t//for(int i=0; i<row.length; i++){" + NL + "\t\t\t\tsb.append(\"| \" + \"";
  protected final String TEXT_48 = "\");" + NL + "\t\t\t\tfor(int i=0; i<titleWidth -\"";
  protected final String TEXT_49 = "\".length()+ 1 ;i++)" + NL + "\t\t\t\t\tsb.append(\" \");" + NL + "\t\t\t\tsb.append(\"| \" + row[";
  protected final String TEXT_50 = "]);" + NL + "\t\t\t\tfor(int i=0; row[";
  protected final String TEXT_51 = "] == null && i<dataWidth - 3 || row[";
  protected final String TEXT_52 = "] != null && i<dataWidth -row[";
  protected final String TEXT_53 = "].length()+ 1 ;i++)" + NL + "\t\t\t\t\tsb.append(\" \");" + NL + "\t\t\t\tsb.append(\"|\" + \"\\n\");" + NL + "\t\t\t" + NL + "\t\t\t//}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t//step 5: print a line gap" + NL + "\t\t\tprintLine(sb,titleWidth,dataWidth);" + NL + "\t\t\treturn sb.toString();" + NL + "" + NL + "\t\t}" + NL + "" + NL + "" + NL + "\t}" + NL + "" + NL + "\tUtil_";
  protected final String TEXT_55 = " util_";
  protected final String TEXT_56 = " = new Util_";
  protected final String TEXT_57 = "();" + NL + "" + NL + "" + NL + "" + NL + "" + NL + "\tjava.io.PrintStream consoleOut_";
  protected final String TEXT_58 = " = null;" + NL + "\tif (globalMap.get(\"tLogRow_CONSOLE\")!=null){" + NL + "        consoleOut_";
  protected final String TEXT_59 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "    }else{" + NL + "        consoleOut_";
  protected final String TEXT_60 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "        globalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_61 = ");" + NL + "    }" + NL;
  protected final String TEXT_62 = NL + "\t\tfinal String OUTPUT_FIELD_SEPARATOR_";
  protected final String TEXT_63 = " = ";
  protected final String TEXT_64 = ";" + NL + "\t\tjava.io.PrintStream consoleOut_";
  protected final String TEXT_65 = " = null;";
  protected final String TEXT_66 = NL + "                    " + NL + "                    " + NL + "                StringBuilder sbHeader_";
  protected final String TEXT_67 = " = new StringBuilder();";
  protected final String TEXT_68 = NL + "\t\t\t\t" + NL + "\t\t\t\tsbHeader_";
  protected final String TEXT_69 = ".append(\"";
  protected final String TEXT_70 = "\");" + NL + "\t\t\t\t";
  protected final String TEXT_71 = NL + "    \t\t\tsbHeader_";
  protected final String TEXT_72 = ".append(\"\\t\");";
  protected final String TEXT_73 = NL + "                   " + NL + "                    if (globalMap.get(\"tLogRow_CONSOLE\")!=null)" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_74 = " = (java.io.PrintStream) globalMap.get(\"tLogRow_CONSOLE\");" + NL + "                    }" + NL + "                    else" + NL + "                    {" + NL + "                    \tconsoleOut_";
  protected final String TEXT_75 = " = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));" + NL + "                    \tglobalMap.put(\"tLogRow_CONSOLE\",consoleOut_";
  protected final String TEXT_76 = ");" + NL + "                    }";
  protected final String TEXT_77 = NL + "                    \tlog.info(\"";
  protected final String TEXT_78 = " - Header names: \" + sbHeader_";
  protected final String TEXT_79 = ".toString());";
  protected final String TEXT_80 = NL + "                    consoleOut_";
  protected final String TEXT_81 = ".println(sbHeader_";
  protected final String TEXT_82 = ".toString());" + NL + "                    consoleOut_";
  protected final String TEXT_83 = ".flush();" + NL + "                    ";
  protected final String TEXT_84 = "\t" + NL;
  protected final String TEXT_85 = NL + " \t\tStringBuilder strBuffer_";
  protected final String TEXT_86 = " = null;" + NL + "\t\tint nb_line_";
  protected final String TEXT_87 = " = 0;" + NL + "///////////////////////    \t\t\t" + NL;
  protected final String TEXT_88 = NL + "\t\t\t\tclass LogRowUtil_";
  protected final String TEXT_89 = "{";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\tpublic void putBasicVerticalValue_";
  protected final String TEXT_91 = "(final ";
  protected final String TEXT_92 = "Struct ";
  protected final String TEXT_93 = ",StringBuilder strBuffer_";
  protected final String TEXT_94 = "){";
  protected final String TEXT_95 = NL + "\t\t\t\t\t\t\tjava.util.Formatter formatter_";
  protected final String TEXT_96 = "_";
  protected final String TEXT_97 = " = new java.util.Formatter(new StringBuilder());";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t\tstrBuffer_";
  protected final String TEXT_99 = ".append(\"";
  protected final String TEXT_100 = ": \");";
  protected final String TEXT_101 = "   \t\t\t\t" + NL + "\t    \t\t\t\t\tif(";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = " != null) { //";
  protected final String TEXT_104 = NL + "\t\t\t\t\t\t\tstrBuffer_";
  protected final String TEXT_105 = ".append(formatter_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = ".format(\"%1$";
  protected final String TEXT_108 = "s\", ";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_110 = ".";
  protected final String TEXT_111 = ", ";
  protected final String TEXT_112 = ")";
  protected final String TEXT_113 = NL + "\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_114 = ".";
  protected final String TEXT_115 = ")).toString()";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_117 = ".toPlainString()";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t\tFormatterUtils.formatUnwithE(";
  protected final String TEXT_119 = ".";
  protected final String TEXT_120 = ")";
  protected final String TEXT_121 = NL + "\t\t\t\t           \tString.valueOf(";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = ")\t\t\t";
  protected final String TEXT_124 = NL + "\t\t\t\t\t\t\t).toString());";
  protected final String TEXT_125 = "\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t\tstrBuffer_";
  protected final String TEXT_126 = ".append(";
  protected final String TEXT_127 = NL + "\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = ", ";
  protected final String TEXT_130 = ")";
  protected final String TEXT_131 = NL + "\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_132 = ".";
  protected final String TEXT_133 = ")).toString()";
  protected final String TEXT_134 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_135 = ".toPlainString()";
  protected final String TEXT_136 = NL + "\t\t\t\t\t\t\tFormatterUtils.formatUnwithE(";
  protected final String TEXT_137 = ".";
  protected final String TEXT_138 = ")";
  protected final String TEXT_139 = NL + "\t\t\t\t            String.valueOf(";
  protected final String TEXT_140 = ".";
  protected final String TEXT_141 = ")\t\t\t";
  protected final String TEXT_142 = "\t\t\t\t" + NL + "\t\t\t\t\t\t\t);";
  protected final String TEXT_143 = NL + "\t    \t\t\t\t} //";
  protected final String TEXT_144 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_145 = NL + "    \t\t\t\t\t\tstrBuffer_";
  protected final String TEXT_146 = ".append(";
  protected final String TEXT_147 = ");";
  protected final String TEXT_148 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_149 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_150 = NL + "\t\t\t\t\t\tpublic void putTableVerticalValue_";
  protected final String TEXT_151 = "(final ";
  protected final String TEXT_152 = "Struct ";
  protected final String TEXT_153 = ",String[] row_";
  protected final String TEXT_154 = "){";
  protected final String TEXT_155 = "   \t\t\t\t" + NL + "\t    \t\t\t\t\tif(";
  protected final String TEXT_156 = ".";
  protected final String TEXT_157 = " != null) { //";
  protected final String TEXT_158 = "              " + NL + "                 \t\t\t\trow_";
  protected final String TEXT_159 = "[";
  protected final String TEXT_160 = "]=    \t\t\t\t\t\t";
  protected final String TEXT_161 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_162 = ".";
  protected final String TEXT_163 = ", ";
  protected final String TEXT_164 = ")";
  protected final String TEXT_165 = NL + "\t\t\t\t\t\t\t\tjava.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ")).toString()";
  protected final String TEXT_168 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_169 = ".toPlainString()";
  protected final String TEXT_170 = NL + "\t\t\t\t\t\t\t\tFormatterUtils.formatUnwithE(";
  protected final String TEXT_171 = ".";
  protected final String TEXT_172 = ")";
  protected final String TEXT_173 = "    " + NL + "\t\t\t\t                String.valueOf(";
  protected final String TEXT_174 = ".";
  protected final String TEXT_175 = ")\t\t\t";
  protected final String TEXT_176 = NL + "\t\t\t\t\t          ;\t";
  protected final String TEXT_177 = NL + "\t    \t\t\t\t\t} //";
  protected final String TEXT_178 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_179 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_180 = NL + "\t\t\t}" + NL + "\t\t\tLogRowUtil_";
  protected final String TEXT_181 = " logRowUtil_";
  protected final String TEXT_182 = "=new LogRowUtil_";
  protected final String TEXT_183 = "();";
  protected final String TEXT_184 = NL;
  protected final String TEXT_185 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {//1
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {//2    

	String cid = node.getUniqueName();
	String label = ElementParameterParser.getValue(node, "__LABEL__");
	if(("__UNIQUE_NAME__").equals(label))
	    label=cid;
    boolean tablePrint = ("true").equals(ElementParameterParser.getValue(node,"__TABLE_PRINT__"));
    String printHeader = ElementParameterParser.getValue(node,"__PRINT_HEADER__");
    boolean vertical = ("true").equals(ElementParameterParser.getValue(node,"__VERTICAL__"));
    boolean uniquePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_UNIQUE__"));
    boolean titlePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_LABEL__"));
    boolean uniqueTitlePrint = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_UNIQUE_LABEL__"));
    boolean basic = !(tablePrint||vertical);
	boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
	boolean isLogContent = ("true").equals(ElementParameterParser.getValue(node,"__PRINT_CONTENT_WITH_LOG4J__"));

	List<IMetadataColumn> columns = metadata.getListColumns();
	int sizeColumns = columns.size();
	
    stringBuffer.append(TEXT_2);
    
    if(tablePrint) { // table display mode
    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(sizeColumns );
    stringBuffer.append(TEXT_7);
     
                if (sizeColumns > 0) { //more than one column
                
    stringBuffer.append(TEXT_8);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_10);
    
                        for ( int i = 0; i < sizeColumns; i++) {
                            
    stringBuffer.append(TEXT_11);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_13);
    
                        }
                        
    stringBuffer.append(TEXT_14);
     
                if (sizeColumns > 1) { 
                    
    stringBuffer.append(TEXT_15);
    
                }
                
    stringBuffer.append(TEXT_16);
    
                for(int i = 0; i< sizeColumns-2;i++) {
                    
    stringBuffer.append(TEXT_17);
    stringBuffer.append(i+1 );
    stringBuffer.append(TEXT_18);
    
                }
                
    stringBuffer.append(TEXT_19);
     
                if (sizeColumns == 1) { 
                    
    stringBuffer.append(TEXT_20);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_21);
     
                } else if (sizeColumns > 1){
                    
    stringBuffer.append(TEXT_22);
    stringBuffer.append(sizeColumns-1 );
    stringBuffer.append(TEXT_23);
    
                }
                
    stringBuffer.append(TEXT_24);
     
            } 
            
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    for(int i=0;i< columns.size();i++){
    stringBuffer.append(TEXT_32);
    stringBuffer.append(columns.get(i).getLabel() );
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    
	} 
	// vertical display mode
	if(vertical) { 

    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    
			if(uniquePrint) {
			    
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
			} else if(titlePrint) {
			    
    stringBuffer.append(TEXT_39);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_40);
    
			} else if(uniqueTitlePrint) {
			    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_43);
    
			}
			
    stringBuffer.append(TEXT_44);
    
			int titleWidth = 3;    //the length of the string 'key'
			for(IMetadataColumn column:columns)
				if(column.getLabel().length()>titleWidth) titleWidth = column.getLabel().length();
			
    stringBuffer.append(TEXT_45);
    stringBuffer.append(titleWidth);
    stringBuffer.append(TEXT_46);
    
			int count = 0;
			for(IMetadataColumn column:columns){
			
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(count);
    stringBuffer.append(TEXT_53);
    
				count++;
			}
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    	
	}
	
	if(basic) {// basic display mode

    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
if (("true").equals(printHeader)) {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
        			
    			for (int i = 0; i < sizeColumns; i++) {
    			IMetadataColumn column = columns.get(i);

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    
				if(i == sizeColumns-1) break;								

    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    
                }   

    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
                    if(isLogContent && isLog4jEnabled){
                    
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    
                    }
                    
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    
	}	

    stringBuffer.append(TEXT_84);
    
  }

    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    
        String printColumnNames = ElementParameterParser.getValue(node,"__PRINT_COLNAMES__");
        String useFixedLength = ElementParameterParser.getValue(node,"__USE_FIXED_LENGTH__");
        List<Map<String, String>> lengths = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__LENGTHS__");
    	List< ? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {//3
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {//4
    			int schemaOptNum=100;
				String schemaOptNumStr=ElementParameterParser.getValue(node, "__SCHEMA_OPT_NUM__");
				if(schemaOptNumStr!=null && !"".equals(schemaOptNumStr) && !"\"\"".equals(schemaOptNumStr)){
					schemaOptNum  = Integer.parseInt(schemaOptNumStr);
				}
				boolean isOptimizeCode = false;
				if(schemaOptNum < sizeColumns){
					isOptimizeCode = true;
				}
    			if(isOptimizeCode){//5

    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    
   				if (basic||vertical) {  // A1
    				for (int i = 0; i < sizeColumns; i++) {//B1
	    				IMetadataColumn column = columns.get(i);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_90);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    
						}
   						if (("true").equals(useFixedLength)) {//fix the column length

    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    
   						}
   						if (("true").equals(printColumnNames)) {//print the schema name

    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    
   						}
						boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
						if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_101);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    
    					} 
   						if (("true").equals(useFixedLength)) {//AAA

    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(lengths.get(i).get("LENGTH") );
    stringBuffer.append(TEXT_108);
    
    						String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    							if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_109);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_112);
    
								} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_113);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    
								} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_117);
    
								} else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_120);
    
								} else {//others

    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_123);
    				
								}

    stringBuffer.append(TEXT_124);
    
   						} else {//AAA

    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    
		    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
		    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_127);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_129);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_130);
    				
							} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_131);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_132);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_133);
    
							} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_134);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_135);
    
							} else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {

    stringBuffer.append(TEXT_136);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_138);
    
							} else {//others

    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_141);
    				
							}

    stringBuffer.append(TEXT_142);
    
  						}//AAA
						if(!isPrimitive) {//end

    stringBuffer.append(TEXT_143);
    
						}
						if(i == sizeColumns-1){
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_144);
    
							}
							break;
						}else{								

    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(ElementParameterParser.getValue(node, "__FIELDSEPARATOR__") );
    stringBuffer.append(TEXT_147);
    
						}
							if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_148);
    
							}
					}//B1
					if(sizeColumns>0 && (sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_149);
    
					}
				}//A1
				if(tablePrint || vertical) { //C1
    				for (int i = 0; i < sizeColumns; i++) {//D1
	    				IMetadataColumn column = columns.get(i);
						JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
						boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
						if(i%schemaOptNum==0){

    stringBuffer.append(TEXT_150);
    stringBuffer.append(i/schemaOptNum);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(NodeUtil.getPrivateConnClassName(conn) );
    stringBuffer.append(TEXT_152);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    
						}
						if(!isPrimitive) { //begin

    stringBuffer.append(TEXT_155);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_157);
    
    					}

    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_160);
    
    					String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    					if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {//Date

    stringBuffer.append(TEXT_161);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_163);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_164);
    				
						} else if (javaType == JavaTypesManager.BYTE_ARRAY) {//byte[]

    stringBuffer.append(TEXT_165);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_166);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_167);
    
						} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_169);
    
						} else if (javaType == JavaTypesManager.DOUBLE || javaType == JavaTypesManager.FLOAT ) {

    stringBuffer.append(TEXT_170);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_172);
    
						} else {//others

    stringBuffer.append(TEXT_173);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_175);
    				
						}

    stringBuffer.append(TEXT_176);
    
						if(!isPrimitive) {//end

    stringBuffer.append(TEXT_177);
    
						} 
						if((i+1)%schemaOptNum==0){

    stringBuffer.append(TEXT_178);
    
						}
					}//D1
					if(sizeColumns>0&&(sizeColumns%schemaOptNum)>0){

    stringBuffer.append(TEXT_179);
    
					}
				}//C1

    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    
				}//5
			}//4
		}//3
    }//2
}//1

    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    return stringBuffer.toString();
  }
}
