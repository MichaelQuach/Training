view: opportunity {
  sql_table_name: SALESFORCE.OPPORTUNITY ;;

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

  dimension: accountid {
    type: string
    # hidden: yes
    sql: ${TABLE}."ACCOUNTID" ;;
  }

  dimension: amount {
    type: number
    sql: ${TABLE}."AMOUNT" ;;
  }

  dimension: budget_confirmed__c {
    type: yesno
    sql: ${TABLE}."BUDGET_CONFIRMED__C" ;;
  }

  dimension_group: closedate {
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
    sql: ${TABLE}."CLOSEDATE" ;;
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

  dimension: discovery_completed__c {
    type: yesno
    sql: ${TABLE}."DISCOVERY_COMPLETED__C" ;;
  }

  dimension: expectedrevenue {
    type: number
    sql: ${TABLE}."EXPECTEDREVENUE" ;;
  }

  measure: sum_expectedrevenue {
    type: sum
    filters: {
      field: expectedrevenue
      value: ">100000"
    }
    label: "Annual_Revenue"
    sql: ${TABLE}."EXPECTEDREVENUE" ;;
    value_format: "$0;($0)"
  }


  dimension: fiscal {
    type: string
    sql: ${TABLE}."FISCAL" ;;
  }

  measure: fiscal1 {
    type: string
    sql: ${TABLE}."FISCAL" ;;
  }

  dimension: fiscalquarter {
    type: string
    sql: ${TABLE}."FISCALQUARTER" ;;
  }

  dimension: fiscalyear {
    type: string
    sql: ${TABLE}."FISCALYEAR" ;;
  }

  dimension: forecastcategory {
    type: string
    sql: ${TABLE}."FORECASTCATEGORY" ;;
  }

  dimension: forecastcategoryname {
    type: string
    sql: ${TABLE}."FORECASTCATEGORYNAME" ;;
  }

  dimension: hasopenactivity {
    type: yesno
    sql: ${TABLE}."HASOPENACTIVITY" ;;
  }

  dimension: hasopportunitylineitem {
    type: yesno
    sql: ${TABLE}."HASOPPORTUNITYLINEITEM" ;;
  }

  dimension: hasoverduetask {
    type: yesno
    sql: ${TABLE}."HASOVERDUETASK" ;;
  }

  dimension: isclosed {
    type: yesno
    sql: ${TABLE}."ISCLOSED" ;;
  }

  dimension: isdeleted {
    type: yesno
    sql: ${TABLE}."ISDELETED" ;;
  }

  dimension: isprivate {
    type: yesno
    sql: ${TABLE}."ISPRIVATE" ;;
  }

  dimension: iswon {
    type: yesno
    sql: ${TABLE}."ISWON" ;;
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

  dimension: lead_check__c {
    type: yesno
    sql: ${TABLE}."LEAD_CHECK__C" ;;
  }

  dimension: leadsource {
    type: string
    sql: ${TABLE}."LEADSOURCE" ;;
  }

  dimension: loss_reason__c {
    type: string
    sql: ${TABLE}."LOSS_REASON__C" ;;
  }

  dimension: name {
    type: string
    sql: ${TABLE}."NAME" ;;
  }

  dimension: nextstep {
    type: string
    sql: ${TABLE}."NEXTSTEP" ;;
  }

  dimension: originating_system__c {
    type: string
    sql: ${TABLE}."ORIGINATING_SYSTEM__C" ;;
  }

  dimension: ownerid {
    type: string
    sql: ${TABLE}."OWNERID" ;;
  }

  dimension: probability {
    type: number
    sql: ${TABLE}."PROBABILITY" ;;
  }

  dimension: reseller__c {
    type: yesno
    sql: ${TABLE}."RESELLER__C" ;;
  }

  dimension: roi_analysis_completed__c {
    type: yesno
    sql: ${TABLE}."ROI_ANALYSIS_COMPLETED__C" ;;
  }

  dimension: sf_amount__c {
    type: number
    sql: ${TABLE}."SF_AMOUNT__C" ;;
  }

  dimension: sf_artifact_required__c {
    type: string
    sql: ${TABLE}."SF_ARTIFACT_REQUIRED__C" ;;
  }

  dimension: sf_bd_group__c {
    type: string
    sql: ${TABLE}."SF_BD_GROUP__C" ;;
  }

  dimension: sf_bd_group_text__c {
    type: string
    sql: ${TABLE}."SF_BD_GROUP_TEXT__C" ;;
  }

  dimension: sf_client_sponsor_name__c {
    type: string
    sql: ${TABLE}."SF_CLIENT_SPONSOR_NAME__C" ;;
  }

  dimension: sf_client_sponsor_title__c {
    type: string
    sql: ${TABLE}."SF_CLIENT_SPONSOR_TITLE__C" ;;
  }

  dimension_group: sf_created_date__c {
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
    sql: ${TABLE}."SF_CREATED_DATE__C" ;;
  }

  dimension: sf_discovery_completed__c {
    type: yesno
    sql: ${TABLE}."SF_DISCOVERY_COMPLETED__C" ;;
  }

  dimension_group: sf_expected_project_start_date__c {
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
    sql: ${TABLE}."SF_EXPECTED_PROJECT_START_DATE__C" ;;
  }

  dimension: sf_forecast_status__c {
    type: string
    sql: ${TABLE}."SF_FORECAST_STATUS__C" ;;
  }

  dimension: sf_gts_remarks__c {
    type: string
    sql: ${TABLE}."SF_GTS_REMARKS__C" ;;
  }

  dimension: sf_implementation__c {
    type: string
    sql: ${TABLE}."SF_IMPLEMENTATION__C" ;;
  }

  dimension: sf_implementation_primary_practice__c {
    type: string
    sql: ${TABLE}."SF_IMPLEMENTATION_PRIMARY_PRACTICE__C" ;;
  }

  dimension: sf_lead_owner__c {
    type: string
    sql: ${TABLE}."SF_LEAD_OWNER__C" ;;
  }

  dimension: sf_list_of_competitors__c {
    type: string
    sql: ${TABLE}."SF_LIST_OF_COMPETITORS__C" ;;
  }

  dimension: sf_loss_reason__c {
    type: string
    sql: ${TABLE}."SF_LOSS_REASON__C" ;;
  }

  dimension: sf_opportunity_no__c {
    type: string
    sql: ${TABLE}."SF_OPPORTUNITY_NO__C" ;;
  }

  dimension: sf_other_service_line__c {
    type: string
    sql: ${TABLE}."SF_OTHER_SERVICE_LINE__C" ;;
  }

  dimension: sf_partner_name__c {
    type: string
    sql: ${TABLE}."SF_PARTNER_NAME__C" ;;
  }

  dimension: sf_pov_owner__c {
    type: string
    sql: ${TABLE}."SF_POV_OWNER__C" ;;
  }

  dimension: sf_pov_required__c {
    type: yesno
    sql: ${TABLE}."SF_POV_REQUIRED__C" ;;
  }

  dimension: sf_pov_status__c {
    type: string
    sql: ${TABLE}."SF_POV_STATUS__C" ;;
  }

  dimension: sf_proposal_doc_uploaded__c {
    type: yesno
    sql: ${TABLE}."SF_PROPOSAL_DOC_UPLOADED__C" ;;
  }

  dimension_group: sf_proposal_due_date__c {
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
    sql: ${TABLE}."SF_PROPOSAL_DUE_DATE__C" ;;
  }

  dimension: sf_proposal_owner__c {
    type: string
    sql: ${TABLE}."SF_PROPOSAL_OWNER__C" ;;
  }

  dimension: sf_proposal_required__c {
    type: yesno
    sql: ${TABLE}."SF_PROPOSAL_REQUIRED__C" ;;
  }

  dimension: sf_proposal_status__c {
    type: string
    sql: ${TABLE}."SF_PROPOSAL_STATUS__C" ;;
  }

  dimension: sf_region__c {
    type: string
    sql: ${TABLE}."SF_REGION__C" ;;
  }

  dimension: sf_region_text__c {
    type: string
    sql: ${TABLE}."SF_REGION_TEXT__C" ;;
  }

  dimension: sf_service_lines__c {
    type: string
    sql: ${TABLE}."SF_SERVICE_LINES__C" ;;
  }

  dimension: sf_service_type__c {
    type: string
    sql: ${TABLE}."SF_SERVICE_TYPE__C" ;;
  }

  dimension: sf_solution_architect_practice_manager__c {
    type: string
    sql: ${TABLE}."SF_SOLUTION_ARCHITECT_PRACTICE_MANAGER__C" ;;
  }

  dimension: sf_sow_owners__c {
    type: string
    sql: ${TABLE}."SF_SOW_OWNERS__C" ;;
  }

  dimension: sf_sow_required__c {
    type: yesno
    sql: ${TABLE}."SF_SOW_REQUIRED__C" ;;
  }

  dimension: sf_sow_status__c {
    type: string
    sql: ${TABLE}."SF_SOW_STATUS__C" ;;
  }

  dimension: sf_technology_platform__c {
    type: string
    sql: ${TABLE}."SF_TECHNOLOGY_PLATFORM__C" ;;
  }

  dimension: sf_trianz_intro_owners__c {
    type: string
    sql: ${TABLE}."SF_TRIANZ_INTRO_OWNERS__C" ;;
  }

  dimension: sf_trianz_intro_required__c {
    type: yesno
    sql: ${TABLE}."SF_TRIANZ_INTRO_REQUIRED__C" ;;
  }

  dimension: sf_trianz_intro_status__c {
    type: string
    sql: ${TABLE}."SF_TRIANZ_INTRO_STATUS__C" ;;
  }

  dimension: software_revenue__c {
    type: number
    sql: ${TABLE}."SOFTWARE_REVENUE__C" ;;
  }

  dimension: stagename {
    type: string
    sql: ${TABLE}."STAGENAME" ;;
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
    drill_fields: [detail*]
  }

  measure: count_id {
    type: count_distinct
    sql: ${accountid} ;;
  }

  # ----- Sets of fields for drilling ------
  set: detail {
    fields: [
      id,
      forecastcategoryname,
      name,
      stagename,
      account.id,
      account.name
    ]
  }
}
