view: account {
  sql_table_name: SALESFORCE.ACCOUNT ;;

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

  dimension: account_lead_source__c {
    type: string
    sql: ${TABLE}."ACCOUNT_LEAD_SOURCE__C" ;;
  }

  dimension: accountsource {
    type: string
    sql: ${TABLE}."ACCOUNTSOURCE" ;;
  }

  dimension: annualrevenue {
    type: number
    sql: ${TABLE}."ANNUALREVENUE" ;;
  }

  dimension: billingaddress {
    type: string
    sql: ${TABLE}."BILLINGADDRESS" ;;
  }

  dimension: billingcity {
    type: string
    sql: ${TABLE}."BILLINGCITY" ;;
  }

  dimension: billingcountry {
    type: string
    sql: ${TABLE}."BILLINGCOUNTRY" ;;
  }

  dimension: billingpostalcode {
    type: string
    sql: ${TABLE}."BILLINGPOSTALCODE" ;;
  }

  dimension: billingstate {
    type: string
    map_layer_name: us_states
    sql: ${TABLE}."BILLINGSTATE" ;;
  }

  dimension: billingstreet {
    type: string
    sql: ${TABLE}."BILLINGSTREET" ;;
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

  dimension: data_quality_description__c {
    type: string
    sql: ${TABLE}."DATA_QUALITY_DESCRIPTION__C" ;;
  }

  dimension: data_quality_score__c {
    type: number
    sql: ${TABLE}."DATA_QUALITY_SCORE__C" ;;
  }

  dimension: description {
    type: string
    sql: ${TABLE}."DESCRIPTION" ;;
  }

  dimension: fax {
    type: string
    sql: ${TABLE}."FAX" ;;
  }

  dimension: industry {
    type: string
    sql: ${TABLE}."INDUSTRY" ;;
  }

  dimension: isdeleted {
    type: yesno
    sql: ${TABLE}."ISDELETED" ;;
  }

  dimension_group: lastactivitydate {
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
    sql: ${TABLE}."LASTACTIVITYDATE" ;;
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

  dimension: name {
    type: string
    sql: ${TABLE}."NAME" ;;
  }

  dimension: number_of_closed_won_opportunities__c {
    type: number
    sql: ${TABLE}."NUMBER_OF_CLOSED_WON_OPPORTUNITIES__C" ;;
  }

  dimension: numberofemployees {
    type: string
    sql: ${TABLE}."NUMBEROFEMPLOYEES" ;;
  }

  dimension: originating_system__c {
    type: string
    sql: ${TABLE}."ORIGINATING_SYSTEM__C" ;;
  }

  dimension: ownerid {
    type: string
    sql: ${TABLE}."OWNERID" ;;
  }

  dimension: parentid {
    type: string
    sql: ${TABLE}."PARENTID" ;;
  }

  dimension: phone {
    type: string
    sql: ${TABLE}."PHONE" ;;
  }

  dimension: photourl {
    type: string
    sql: ${TABLE}."PHOTOURL" ;;
  }

  dimension: sf_account_lead_source__c {
    type: string
    sql: ${TABLE}."SF_ACCOUNT_LEAD_SOURCE__C" ;;
  }

  dimension: sf_account_number__c {
    type: string
    sql: ${TABLE}."SF_ACCOUNT_NUMBER__C" ;;
  }

  dimension: sf_account_owner__c {
    type: string
    sql: ${TABLE}."SF_ACCOUNT_OWNER__C" ;;
  }

  dimension: sf_bd_group__c {
    type: string
    sql: ${TABLE}."SF_BD_GROUP__C" ;;
  }

  dimension: sf_do_not_call__c {
    type: yesno
    sql: ${TABLE}."SF_DO_NOT_CALL__C" ;;
  }

  dimension: sf_lead_owner__c {
    type: string
    sql: ${TABLE}."SF_LEAD_OWNER__C" ;;
  }

  dimension: sf_partner_name__c {
    type: string
    sql: ${TABLE}."SF_PARTNER_NAME__C" ;;
  }

  dimension: sf_region__c {
    type: string
    sql: ${TABLE}."SF_REGION__C" ;;
  }

  dimension: shippingaddress {
    type: string
    sql: ${TABLE}."SHIPPINGADDRESS" ;;
  }

  dimension: shippingcity {
    type: string
    sql: ${TABLE}."SHIPPINGCITY" ;;
  }

  dimension: shippingcountry {
    type: string
    sql: ${TABLE}."SHIPPINGCOUNTRY" ;;
  }

  dimension: shippingpostalcode {
    type: string
    sql: ${TABLE}."SHIPPINGPOSTALCODE" ;;
  }

  dimension: shippingstate {
    type: string
    sql: ${TABLE}."SHIPPINGSTATE" ;;
  }

  dimension: shippingstreet {
    type: string
    sql: ${TABLE}."SHIPPINGSTREET" ;;
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

  dimension: type {
    type: string
    sql: ${TABLE}."TYPE" ;;
  }

  dimension: website {
    type: string
    sql: ${TABLE}."WEBSITE" ;;
  }

  measure: annual_revenue {
    type: sum
    label: "Annual_Revenue"
    sql: ${TABLE}."ANNUALREVENUE" ;;
    value_format: "$0.000M"
  }

  measure: cou_id {
    type: count_distinct
    sql: ${TABLE}."ID" ;;
  }


  measure: count {
    type: count
    drill_fields: [id, name, contact.count, opportunity.count]
  }
}
