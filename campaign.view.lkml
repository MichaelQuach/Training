view: campaign {
  sql_table_name: SALESFORCE.CAMPAIGN ;;

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

  dimension: amountallopportunities {
    type: number
    sql: ${TABLE}."AMOUNTALLOPPORTUNITIES" ;;
  }

  dimension: amountwonopportunities {
    type: number
    sql: ${TABLE}."AMOUNTWONOPPORTUNITIES" ;;
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

  dimension_group: enddate {
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
    sql: ${TABLE}."ENDDATE" ;;
  }

  dimension: expectedresponse {
    type: number
    sql: ${TABLE}."EXPECTEDRESPONSE" ;;
  }

  dimension: isactive {
    type: yesno
    sql: ${TABLE}."ISACTIVE" ;;
  }

  dimension: isdeleted {
    type: yesno
    sql: ${TABLE}."ISDELETED" ;;
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

  dimension: numberofcontacts {
    type: string
    sql: ${TABLE}."NUMBEROFCONTACTS" ;;
  }

  dimension: numberofconvertedleads {
    type: string
    sql: ${TABLE}."NUMBEROFCONVERTEDLEADS" ;;
  }

  dimension: numberofleads {
    type: string
    sql: ${TABLE}."NUMBEROFLEADS" ;;
  }

  dimension: numberofopportunities {
    type: string
    sql: ${TABLE}."NUMBEROFOPPORTUNITIES" ;;
  }

  dimension: numberofresponses {
    type: string
    sql: ${TABLE}."NUMBEROFRESPONSES" ;;
  }

  dimension: numberofwonopportunities {
    type: string
    sql: ${TABLE}."NUMBEROFWONOPPORTUNITIES" ;;
  }

  dimension: numbersent {
    type: number
    sql: ${TABLE}."NUMBERSENT" ;;
  }

  dimension: ownerid {
    type: string
    sql: ${TABLE}."OWNERID" ;;
  }

  dimension_group: startdate {
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
    sql: ${TABLE}."STARTDATE" ;;
  }

  dimension: status {
    type: string
    sql: ${TABLE}."STATUS" ;;
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

  measure: count {
    type: count
    drill_fields: [id, name]
  }
}
