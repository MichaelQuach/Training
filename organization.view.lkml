view: organization {
  sql_table_name: SALESFORCE.ORGANIZATION ;;

  dimension: id {
    primary_key: yes
    type: string
    sql: ${TABLE}."ID" ;;
  }

  dimension_group: _sdc_batched {
    type: time
    timeframes: [
      raw,
      time,
      date,
      week,
      month,
      quarter,
      year
    ]
    sql: ${TABLE}."_SDC_BATCHED_AT" ;;
  }

  dimension_group: _sdc_extracted {
    type: time
    timeframes: [
      raw,
      time,
      date,
      week,
      month,
      quarter,
      year
    ]
    sql: ${TABLE}."_SDC_EXTRACTED_AT" ;;
  }

  dimension_group: _sdc_received {
    type: time
    timeframes: [
      raw,
      time,
      date,
      week,
      month,
      quarter,
      year
    ]
    sql: ${TABLE}."_SDC_RECEIVED_AT" ;;
  }

  dimension: _sdc_sequence {
    type: string
    sql: ${TABLE}."_SDC_SEQUENCE" ;;
  }

  dimension: _sdc_table_version {
    type: string
    sql: ${TABLE}."_SDC_TABLE_VERSION" ;;
  }

  dimension: address {
    type: string
    sql: ${TABLE}."ADDRESS" ;;
  }

  dimension: country {
    type: string
    map_layer_name: countries
    sql: ${TABLE}."COUNTRY" ;;
  }

  dimension: createdbyid {
    type: string
    sql: ${TABLE}."CREATEDBYID" ;;
  }

  dimension_group: createddate {
    type: time
    timeframes: [
      raw,
      time,
      date,
      week,
      month,
      quarter,
      year
    ]
    sql: ${TABLE}."CREATEDDATE" ;;
  }

  dimension: defaultaccountaccess {
    type: string
    sql: ${TABLE}."DEFAULTACCOUNTACCESS" ;;
  }

  dimension: defaultcalendaraccess {
    type: string
    sql: ${TABLE}."DEFAULTCALENDARACCESS" ;;
  }

  dimension: defaultcampaignaccess {
    type: string
    sql: ${TABLE}."DEFAULTCAMPAIGNACCESS" ;;
  }

  dimension: defaultcaseaccess {
    type: string
    sql: ${TABLE}."DEFAULTCASEACCESS" ;;
  }

  dimension: defaultcontactaccess {
    type: string
    sql: ${TABLE}."DEFAULTCONTACTACCESS" ;;
  }

  dimension: defaultleadaccess {
    type: string
    sql: ${TABLE}."DEFAULTLEADACCESS" ;;
  }

  dimension: defaultlocalesidkey {
    type: string
    sql: ${TABLE}."DEFAULTLOCALESIDKEY" ;;
  }

  dimension: defaultopportunityaccess {
    type: string
    sql: ${TABLE}."DEFAULTOPPORTUNITYACCESS" ;;
  }

  dimension: defaultpricebookaccess {
    type: string
    sql: ${TABLE}."DEFAULTPRICEBOOKACCESS" ;;
  }

  dimension: fiscalyearstartmonth {
    type: string
    sql: ${TABLE}."FISCALYEARSTARTMONTH" ;;
  }

  dimension: instancename {
    type: string
    sql: ${TABLE}."INSTANCENAME" ;;
  }

  dimension: isreadonly {
    type: yesno
    sql: ${TABLE}."ISREADONLY" ;;
  }

  dimension: issandbox {
    type: yesno
    sql: ${TABLE}."ISSANDBOX" ;;
  }

  dimension: languagelocalekey {
    type: string
    sql: ${TABLE}."LANGUAGELOCALEKEY" ;;
  }

  dimension: lastmodifiedbyid {
    type: string
    sql: ${TABLE}."LASTMODIFIEDBYID" ;;
  }

  dimension_group: lastmodifieddate {
    type: time
    timeframes: [
      raw,
      time,
      date,
      week,
      month,
      quarter,
      year
    ]
    sql: ${TABLE}."LASTMODIFIEDDATE" ;;
  }

  dimension: monthlypageviewsentitlement {
    type: string
    sql: ${TABLE}."MONTHLYPAGEVIEWSENTITLEMENT" ;;
  }

  dimension: monthlypageviewsused {
    type: string
    sql: ${TABLE}."MONTHLYPAGEVIEWSUSED" ;;
  }

  dimension: name {
    type: string
    sql: ${TABLE}."NAME" ;;
  }

  dimension: organizationtype {
    type: string
    sql: ${TABLE}."ORGANIZATIONTYPE" ;;
  }

  dimension: preferenceslightningloginenabled {
    type: yesno
    sql: ${TABLE}."PREFERENCESLIGHTNINGLOGINENABLED" ;;
  }

  dimension: preferencesonlyllpermuserallowed {
    type: yesno
    sql: ${TABLE}."PREFERENCESONLYLLPERMUSERALLOWED" ;;
  }

  dimension: preferencesrequireopportunityproducts {
    type: yesno
    sql: ${TABLE}."PREFERENCESREQUIREOPPORTUNITYPRODUCTS" ;;
  }

  dimension: primarycontact {
    type: string
    sql: ${TABLE}."PRIMARYCONTACT" ;;
  }

  dimension: receivesadmininfoemails {
    type: yesno
    sql: ${TABLE}."RECEIVESADMININFOEMAILS" ;;
  }

  dimension: receivesinfoemails {
    type: yesno
    sql: ${TABLE}."RECEIVESINFOEMAILS" ;;
  }

  dimension: signupcountryisocode {
    type: string
    sql: ${TABLE}."SIGNUPCOUNTRYISOCODE" ;;
  }

  dimension_group: systemmodstamp {
    type: time
    timeframes: [
      raw,
      time,
      date,
      week,
      month,
      quarter,
      year
    ]
    sql: ${TABLE}."SYSTEMMODSTAMP" ;;
  }

  dimension: totaltrustedrequestslimit {
    type: string
    sql: ${TABLE}."TOTALTRUSTEDREQUESTSLIMIT" ;;
  }

  dimension: totaltrustedrequestsusage {
    type: string
    sql: ${TABLE}."TOTALTRUSTEDREQUESTSUSAGE" ;;
  }

  dimension: uiskin {
    type: string
    sql: ${TABLE}."UISKIN" ;;
  }

  dimension: usesstartdateasfiscalyearname {
    type: yesno
    sql: ${TABLE}."USESSTARTDATEASFISCALYEARNAME" ;;
  }

  measure: count {
    type: count
    drill_fields: [id, instancename, name, usesstartdateasfiscalyearname]
  }
}
