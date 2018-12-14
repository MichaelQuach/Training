/*METADATATalendMDMSearch createSearch(String host, String port, String user, String password, String version)=Returns a TalendMDMSearch object to be used as a parameter for search functions
Map<String,String> getItemsMapWithFilter(TalendMDMSearch search, String dataContainer, String entity, String idName, String labelName, String filterName, String filterValue)=No Documentation
String getLabelFromId(TalendMDMSearch search, String dataContainer, String entity, String idName, String idValue, String labelName)=No Documentation
Map<String,String> getItemsMap(TalendMDMSearch search, String dataContainer, String entity, String idName, String labelName)=No Documentation
*/
//package;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.talend.mdm.workflow.client.TalendMDMSearch;
import org.talend.mdm.workflow.client.util.MDMSearchResultSet;

public class MDM {

    public static TalendMDMSearch createSearch(String host, String port, String user, String password, String version) {
        int p=Integer.parseInt(port);
        return new TalendMDMSearch(host, p, user, password, version);
    }

    public static Map<String, String> getItemsMap(TalendMDMSearch search, String dataContainer,
            String entity, String idName, String labelName) {
        search.clearWhereCondition();
        List<String> list = new ArrayList<String>();
        list.add(entity + '/' + idName);
        list.add(entity + '/' + labelName);
        MDMSearchResultSet r = search.execute(dataContainer, entity, list, -1);
        return r.getNodeMap(labelName, idName);
    }

    public static Map<String, String> getItemsMapWithFilter(TalendMDMSearch search,
            String dataContainer, String entity, String idName, String labelName, String filterName, String filterValue) {
        search.clearWhereCondition();
        search.addWhereItem(entity + '/' + filterName, TalendMDMSearch.WhereOperator.EQUALS, filterValue,
                TalendMDMSearch.WherePredicate.NONE);
        List<String> list = new ArrayList<String>();
        list.add(entity + '/' + idName);
        list.add(entity + '/' + labelName);
        MDMSearchResultSet r = search.execute(dataContainer, entity, list, -1);
        return r.getNodeMap(labelName, idName);
    }

    public static String getLabelFromId(TalendMDMSearch search, String dataContainer, String entity,
            String idName, String idValue, String labelName) {
        search.clearWhereCondition();
        search.addWhereItem(entity + '/' + idName, TalendMDMSearch.WhereOperator.EQUALS, idValue, TalendMDMSearch.WherePredicate.NONE);
        List<String> list = new ArrayList<String>();
        list.add(entity + '/' + labelName);
        MDMSearchResultSet r = search.execute(dataContainer, entity, list, -1);
        return r.getXMLResult(0);
    }
}