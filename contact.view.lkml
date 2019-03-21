view: contact {

  sql_table_name: SALESFORCE.CONTACT ;;

  dimension: sf_contact_id__c {
    primary_key: yes
    type: string
    sql: ${TABLE}."SF_CONTACT_ID__C" ;;
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

  dimension: accountid {
    type: string
    # hidden: yes
    sql: ${TABLE}."ACCOUNTID" ;;
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

  dimension: department {
    type: string
    sql: ${TABLE}."DEPARTMENT" ;;
  }

  dimension: description {
    type: string
    sql: ${TABLE}."DESCRIPTION" ;;
  }

  dimension: email {
    type: string
    sql: ${TABLE}."EMAIL" ;;
  }

  dimension: fax {
    type: string
    sql: ${TABLE}."FAX" ;;
  }

  dimension: firstname {
    type: string
    sql: ${TABLE}."FIRSTNAME" ;;
  }

  dimension: hasoptedoutofemail {
    type: yesno
    sql: ${TABLE}."HASOPTEDOUTOFEMAIL" ;;
  }

  dimension: id {
    type: string
    sql: ${TABLE}."ID" ;;
  }

  dimension: isdeleted {
    type: yesno
    sql: ${TABLE}."ISDELETED" ;;
  }

  dimension: isemailbounced {
    type: yesno
    sql: ${TABLE}."ISEMAILBOUNCED" ;;
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

  dimension: lastname {
    type: string
    sql: ${TABLE}."LASTNAME" ;;
  }

  dimension: leadsource {
    type: string
    sql: ${TABLE}."LEADSOURCE" ;;
  }

  dimension: mailingaddress {
    type: string
    sql: ${TABLE}."MAILINGADDRESS" ;;
  }

  dimension: mailingcity {
    type: string
    sql: ${TABLE}."MAILINGCITY" ;;
  }

  dimension: mailingcountry {
    type: string
    sql: ${TABLE}."MAILINGCOUNTRY" ;;
  }

  dimension: mailingpostalcode {
    type: string
    sql: ${TABLE}."MAILINGPOSTALCODE" ;;
  }

  dimension: mailingstate {
    type: string
    sql: ${TABLE}."MAILINGSTATE" ;;
  }

  dimension: mailingstreet {
    type: string
    sql: ${TABLE}."MAILINGSTREET" ;;
  }

  dimension: middlename {
    type: string
    sql: ${TABLE}."MIDDLENAME" ;;
  }

  dimension: mobilephone {
    type: string
    sql: ${TABLE}."MOBILEPHONE" ;;
  }

  dimension: name {
    type: string
    sql: ${TABLE}."NAME" ;;
  }

  dimension: originating_system__c {
    type: string
    sql: ${TABLE}."ORIGINATING_SYSTEM__C" ;;
  }

  dimension: ownerid {
    type: string
    sql: ${TABLE}."OWNERID" ;;
  }

  dimension: phone {
    type: string
    sql: ${TABLE}."PHONE" ;;
  }

  dimension: photourl {
    type: string
    sql: ${TABLE}."PHOTOURL" ;;
  }

  dimension: pi__campaign__c {
    type: string
    sql: ${TABLE}."PI__CAMPAIGN__C" ;;
  }

  dimension: pi__comments__c {
    type: string
    sql: ${TABLE}."PI__COMMENTS__C" ;;
  }

  dimension_group: pi__conversion_date__c {
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
    sql: ${TABLE}."PI__CONVERSION_DATE__C" ;;
  }

  dimension: pi__conversion_object_name__c {
    type: string
    sql: ${TABLE}."PI__CONVERSION_OBJECT_NAME__C" ;;
  }

  dimension: pi__conversion_object_type__c {
    type: string
    sql: ${TABLE}."PI__CONVERSION_OBJECT_TYPE__C" ;;
  }

  dimension_group: pi__created_date__c {
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
    sql: ${TABLE}."PI__CREATED_DATE__C" ;;
  }

  dimension_group: pi__first_activity__c {
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
    sql: ${TABLE}."PI__FIRST_ACTIVITY__C" ;;
  }

  dimension_group: pi__last_activity__c {
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
    sql: ${TABLE}."PI__LAST_ACTIVITY__C" ;;
  }

  dimension: pi__needs_score_synced__c {
    type: yesno
    sql: ${TABLE}."PI__NEEDS_SCORE_SYNCED__C" ;;
  }

  dimension: pi__notes__c {
    type: string
    sql: ${TABLE}."PI__NOTES__C" ;;
  }

  dimension: pi__pardot_hard_bounced__c {
    type: yesno
    sql: ${TABLE}."PI__PARDOT_HARD_BOUNCED__C" ;;
  }

  dimension_group: pi__pardot_last_scored_at__c {
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
    sql: ${TABLE}."PI__PARDOT_LAST_SCORED_AT__C" ;;
  }

  dimension: pi__score__c {
    type: number
    sql: ${TABLE}."PI__SCORE__C" ;;
  }

  dimension: pi__url__c {
    type: string
    sql: ${TABLE}."PI__URL__C" ;;
  }

  dimension: rcsfl__sendsms__c {
    type: string
    sql: ${TABLE}."RCSFL__SENDSMS__C" ;;
  }

  dimension: salutation {
    type: string
    sql: ${TABLE}."SALUTATION" ;;
  }

  dimension: sf_bd_group__c {
    type: string
    sql: ${TABLE}."SF_BD_GROUP__C" ;;
  }

  dimension: sf_comments__c {
    type: string
    sql: ${TABLE}."SF_COMMENTS__C" ;;
  }

  dimension: sf_portal_user__c {
    type: yesno
    sql: ${TABLE}."SF_PORTAL_USER__C" ;;
  }

  dimension: sf_region__c {
    type: string
    sql: ${TABLE}."SF_REGION__C" ;;
  }

  dimension: suffix {
    type: string
    sql: ${TABLE}."SUFFIX" ;;
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

  dimension: title {
    type: string
    sql: ${TABLE}."TITLE" ;;
  }

  measure: count {
    type: count
    drill_fields: [detail*]
  }

  # ----- Sets of fields for drilling ------
  set: detail {
    fields: [
      sf_contact_id__c,
      firstname,
      lastname,
      middlename,
      name,
      account.id,
      account.name
    ]
  }
}
