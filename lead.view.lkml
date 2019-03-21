view: lead {
  sql_table_name: SALESFORCE.LEAD ;;

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

  dimension: account_user_name__c {
    type: string
    sql: ${TABLE}."ACCOUNT_USER_NAME__C" ;;
  }

  dimension: address {
    type: string
    sql: ${TABLE}."ADDRESS" ;;
  }

  dimension: annualrevenue {
    type: number
    sql: ${TABLE}."ANNUALREVENUE" ;;
  }

  dimension: business_days__c {
    type: string
    sql: ${TABLE}."BUSINESS_DAYS__C" ;;
  }

  dimension: city {
    type: string
    sql: ${TABLE}."CITY" ;;
  }

  dimension: company {
    type: string
    sql: ${TABLE}."COMPANY" ;;
  }

  dimension: convertedaccountid {
    type: string
    sql: ${TABLE}."CONVERTEDACCOUNTID" ;;
  }

  dimension: convertedcontactid {
    type: string
    sql: ${TABLE}."CONVERTEDCONTACTID" ;;
  }

  dimension_group: converteddate {
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
    sql: ${TABLE}."CONVERTEDDATE" ;;
  }

  dimension: convertedopportunityid {
    type: string
    sql: ${TABLE}."CONVERTEDOPPORTUNITYID" ;;
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

  dimension: data_quality_description__c {
    type: string
    sql: ${TABLE}."DATA_QUALITY_DESCRIPTION__C" ;;
  }

  dimension: data_quality_score__c {
    type: number
    sql: ${TABLE}."DATA_QUALITY_SCORE__C" ;;
  }

  dimension_group: db_created_date_without_time__c {
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
    sql: ${TABLE}."DB_CREATED_DATE_WITHOUT_TIME__C" ;;
  }

  dimension: db_lead_age__c {
    type: number
    sql: ${TABLE}."DB_LEAD_AGE__C" ;;
  }

  dimension: description {
    type: string
    sql: ${TABLE}."DESCRIPTION" ;;
  }

  dimension: email {
    type: string
    sql: ${TABLE}."EMAIL" ;;
  }

  dimension_group: emailbounceddate {
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
    sql: ${TABLE}."EMAILBOUNCEDDATE" ;;
  }

  dimension: emailbouncedreason {
    type: string
    sql: ${TABLE}."EMAILBOUNCEDREASON" ;;
  }

  dimension: fax {
    type: string
    sql: ${TABLE}."FAX" ;;
  }

  dimension: firstname {
    type: string
    sql: ${TABLE}."FIRSTNAME" ;;
  }

  dimension: group_user__c {
    type: string
    sql: ${TABLE}."GROUP_USER__C" ;;
  }

  dimension: hasoptedoutofemail {
    type: yesno
    sql: ${TABLE}."HASOPTEDOUTOFEMAIL" ;;
  }

  dimension: industry {
    type: string
    sql: ${TABLE}."INDUSTRY" ;;
  }

  dimension: isconverted {
    type: yesno
    sql: ${TABLE}."ISCONVERTED" ;;
  }

  dimension: isdeleted {
    type: yesno
    sql: ${TABLE}."ISDELETED" ;;
  }

  dimension: isunreadbyowner {
    type: yesno
    sql: ${TABLE}."ISUNREADBYOWNER" ;;
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

  dimension: numberofemployees {
    type: string
    sql: ${TABLE}."NUMBEROFEMPLOYEES" ;;
  }

  dimension: opportunity_check__c {
    type: yesno
    sql: ${TABLE}."OPPORTUNITY_CHECK__C" ;;
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

  dimension: pi__first_touch_url__c {
    type: string
    sql: ${TABLE}."PI__FIRST_TOUCH_URL__C" ;;
  }

  dimension: pi__grade__c {
    type: string
    sql: ${TABLE}."PI__GRADE__C" ;;
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

  dimension: pi_linkedin_url__c {
    type: string
    sql: ${TABLE}."PI_LINKEDIN_URL__C" ;;
  }

  dimension: postalcode {
    type: string
    sql: ${TABLE}."POSTALCODE" ;;
  }

  dimension: rating {
    type: string
    sql: ${TABLE}."RATING" ;;
  }

  dimension: salutation {
    type: string
    sql: ${TABLE}."SALUTATION" ;;
  }

  dimension: sf_account_lead_source1__c {
    type: string
    sql: ${TABLE}."SF_ACCOUNT_LEAD_SOURCE1__C" ;;
  }

  dimension: sf_bd_group__c {
    type: string
    sql: ${TABLE}."SF_BD_GROUP__C" ;;
  }

  dimension: sf_lead_number__c {
    type: string
    sql: ${TABLE}."SF_LEAD_NUMBER__C" ;;
  }

  dimension: sf_lead_owner__c {
    type: string
    sql: ${TABLE}."SF_LEAD_OWNER__C" ;;
  }

  dimension: sf_partner_name__c {
    type: string
    sql: ${TABLE}."SF_PARTNER_NAME__C" ;;
  }

  dimension: state {
    type: string
    sql: ${TABLE}."STATE" ;;
  }

  dimension: status {
    type: string
    sql: ${TABLE}."STATUS" ;;
  }

  dimension: street {
    type: string
    sql: ${TABLE}."STREET" ;;
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

  dimension: website {
    type: string
    sql: ${TABLE}."WEBSITE" ;;
  }

  measure: count {
    type: count
    drill_fields: [id, firstname, lastname, middlename, name]
  }
}
