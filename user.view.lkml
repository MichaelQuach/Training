view: user {
  sql_table_name: SALESFORCE."USER" ;;

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

  dimension: aboutme {
    type: string
    sql: ${TABLE}."ABOUTME" ;;
  }

  dimension: address {
    type: string
    sql: ${TABLE}."ADDRESS" ;;
  }

  dimension: alias {
    type: string
    sql: ${TABLE}."ALIAS" ;;
  }

  dimension: bannerphotourl {
    type: string
    sql: ${TABLE}."BANNERPHOTOURL" ;;
  }

  dimension: bd_group__c {
    type: string
    sql: ${TABLE}."BD_GROUP__C" ;;
  }

  dimension: callcenterid {
    type: string
    sql: ${TABLE}."CALLCENTERID" ;;
  }

  dimension: city {
    type: string
    sql: ${TABLE}."CITY" ;;
  }

  dimension: communitynickname {
    type: string
    sql: ${TABLE}."COMMUNITYNICKNAME" ;;
  }

  dimension: companyname {
    type: string
    sql: ${TABLE}."COMPANYNAME" ;;
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

  dimension: defaultgroupnotificationfrequency {
    type: string
    sql: ${TABLE}."DEFAULTGROUPNOTIFICATIONFREQUENCY" ;;
  }

  dimension: delegatedapproverid {
    type: string
    sql: ${TABLE}."DELEGATEDAPPROVERID" ;;
  }

  dimension: department {
    type: string
    sql: ${TABLE}."DEPARTMENT" ;;
  }

  dimension: digestfrequency {
    type: string
    sql: ${TABLE}."DIGESTFREQUENCY" ;;
  }

  dimension: division {
    type: string
    sql: ${TABLE}."DIVISION" ;;
  }

  dimension: email {
    type: string
    sql: ${TABLE}."EMAIL" ;;
  }

  dimension: emailencodingkey {
    type: string
    sql: ${TABLE}."EMAILENCODINGKEY" ;;
  }

  dimension: emailpreferencesautobcc {
    type: yesno
    sql: ${TABLE}."EMAILPREFERENCESAUTOBCC" ;;
  }

  dimension: emailpreferencesautobccstayintouch {
    type: yesno
    sql: ${TABLE}."EMAILPREFERENCESAUTOBCCSTAYINTOUCH" ;;
  }

  dimension: emailpreferencesstayintouchreminder {
    type: yesno
    sql: ${TABLE}."EMAILPREFERENCESSTAYINTOUCHREMINDER" ;;
  }

  dimension: employeenumber {
    type: string
    sql: ${TABLE}."EMPLOYEENUMBER" ;;
  }

  dimension: fax {
    type: string
    sql: ${TABLE}."FAX" ;;
  }

  dimension: firstname {
    type: string
    sql: ${TABLE}."FIRSTNAME" ;;
  }

  dimension: forecastenabled {
    type: yesno
    sql: ${TABLE}."FORECASTENABLED" ;;
  }

  dimension: fullphotourl {
    type: string
    sql: ${TABLE}."FULLPHOTOURL" ;;
  }

  dimension: isactive {
    type: yesno
    sql: ${TABLE}."ISACTIVE" ;;
  }

  dimension: isextindicatorvisible {
    type: yesno
    sql: ${TABLE}."ISEXTINDICATORVISIBLE" ;;
  }

  dimension: isprofilephotoactive {
    type: yesno
    sql: ${TABLE}."ISPROFILEPHOTOACTIVE" ;;
  }

  dimension: languagelocalekey {
    type: string
    sql: ${TABLE}."LANGUAGELOCALEKEY" ;;
  }

  dimension_group: lastlogindate {
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
    sql: ${TABLE}."LASTLOGINDATE" ;;
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

  dimension_group: lastpasswordchangedate {
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
    sql: ${TABLE}."LASTPASSWORDCHANGEDATE" ;;
  }

  dimension_group: lastreferenceddate {
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
    sql: ${TABLE}."LASTREFERENCEDDATE" ;;
  }

  dimension_group: lastvieweddate {
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
    sql: ${TABLE}."LASTVIEWEDDATE" ;;
  }

  dimension: localesidkey {
    type: string
    sql: ${TABLE}."LOCALESIDKEY" ;;
  }

  dimension: managerid {
    type: string
    sql: ${TABLE}."MANAGERID" ;;
  }

  dimension: mediumbannerphotourl {
    type: string
    sql: ${TABLE}."MEDIUMBANNERPHOTOURL" ;;
  }

  dimension: mediumphotourl {
    type: string
    sql: ${TABLE}."MEDIUMPHOTOURL" ;;
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

  dimension: phone {
    type: string
    sql: ${TABLE}."PHONE" ;;
  }

  dimension: pi__can_view_not_assigned_prospects__c {
    type: yesno
    sql: ${TABLE}."PI__CAN_VIEW_NOT_ASSIGNED_PROSPECTS__C" ;;
  }

  dimension: postalcode {
    type: string
    sql: ${TABLE}."POSTALCODE" ;;
  }

  dimension: profileid {
    type: string
    sql: ${TABLE}."PROFILEID" ;;
  }

  dimension: receivesadmininfoemails {
    type: yesno
    sql: ${TABLE}."RECEIVESADMININFOEMAILS" ;;
  }

  dimension: receivesinfoemails {
    type: yesno
    sql: ${TABLE}."RECEIVESINFOEMAILS" ;;
  }

  dimension: signature {
    type: string
    sql: ${TABLE}."SIGNATURE" ;;
  }

  dimension: smallbannerphotourl {
    type: string
    sql: ${TABLE}."SMALLBANNERPHOTOURL" ;;
  }

  dimension: smallphotourl {
    type: string
    sql: ${TABLE}."SMALLPHOTOURL" ;;
  }

  dimension: state {
    type: string
    sql: ${TABLE}."STATE" ;;
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

  dimension: timezonesidkey {
    type: string
    sql: ${TABLE}."TIMEZONESIDKEY" ;;
  }

  dimension: title {
    type: string
    sql: ${TABLE}."TITLE" ;;
  }

  dimension: username {
    type: string
    sql: ${TABLE}."USERNAME" ;;
  }

  dimension: userpermissionsavantgouser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSAVANTGOUSER" ;;
  }

  dimension: userpermissionscallcenterautologin {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSCALLCENTERAUTOLOGIN" ;;
  }

  dimension: userpermissionsinteractionuser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSINTERACTIONUSER" ;;
  }

  dimension: userpermissionsmarketinguser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSMARKETINGUSER" ;;
  }

  dimension: userpermissionsmobileuser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSMOBILEUSER" ;;
  }

  dimension: userpermissionsofflineuser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSOFFLINEUSER" ;;
  }

  dimension: userpermissionssfcontentuser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSSFCONTENTUSER" ;;
  }

  dimension: userpermissionssupportuser {
    type: yesno
    sql: ${TABLE}."USERPERMISSIONSSUPPORTUSER" ;;
  }

  dimension: userpreferencesactivityreminderspopup {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESACTIVITYREMINDERSPOPUP" ;;
  }

  dimension: userpreferencesapexpagesdevelopermode {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESAPEXPAGESDEVELOPERMODE" ;;
  }

  dimension: userpreferencescachediagnostics {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESCACHEDIAGNOSTICS" ;;
  }

  dimension: userpreferencescreatelexappswtshown {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESCREATELEXAPPSWTSHOWN" ;;
  }

  dimension: userpreferencesdisableallfeedsemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEALLFEEDSEMAIL" ;;
  }

  dimension: userpreferencesdisablebookmarkemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEBOOKMARKEMAIL" ;;
  }

  dimension: userpreferencesdisablechangecommentemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLECHANGECOMMENTEMAIL" ;;
  }

  dimension: userpreferencesdisableendorsementemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEENDORSEMENTEMAIL" ;;
  }

  dimension: userpreferencesdisablefilesharenotificationsforapi {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEFILESHARENOTIFICATIONSFORAPI" ;;
  }

  dimension: userpreferencesdisablefollowersemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEFOLLOWERSEMAIL" ;;
  }

  dimension: userpreferencesdisablelatercommentemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLELATERCOMMENTEMAIL" ;;
  }

  dimension: userpreferencesdisablelikeemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLELIKEEMAIL" ;;
  }

  dimension: userpreferencesdisablementionspostemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEMENTIONSPOSTEMAIL" ;;
  }

  dimension: userpreferencesdisablemessageemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEMESSAGEEMAIL" ;;
  }

  dimension: userpreferencesdisableprofilepostemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLEPROFILEPOSTEMAIL" ;;
  }

  dimension: userpreferencesdisablesharepostemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISABLESHAREPOSTEMAIL" ;;
  }

  dimension: userpreferencesdiscommentafterlikeemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISCOMMENTAFTERLIKEEMAIL" ;;
  }

  dimension: userpreferencesdismentionscommentemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISMENTIONSCOMMENTEMAIL" ;;
  }

  dimension: userpreferencesdisprofpostcommentemail {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESDISPROFPOSTCOMMENTEMAIL" ;;
  }

  dimension: userpreferencesenableautosubforfeeds {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESENABLEAUTOSUBFORFEEDS" ;;
  }

  dimension: userpreferenceseventreminderscheckboxdefault {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESEVENTREMINDERSCHECKBOXDEFAULT" ;;
  }

  dimension: userpreferencesexcludemailappattachments {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESEXCLUDEMAILAPPATTACHMENTS" ;;
  }

  dimension: userpreferencesfavoritesshowtopfavorites {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESFAVORITESSHOWTOPFAVORITES" ;;
  }

  dimension: userpreferencesfavoriteswtshown {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESFAVORITESWTSHOWN" ;;
  }

  dimension: userpreferencesglobalnavbarwtshown {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESGLOBALNAVBARWTSHOWN" ;;
  }

  dimension: userpreferencesglobalnavgridmenuwtshown {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESGLOBALNAVGRIDMENUWTSHOWN" ;;
  }

  dimension: userpreferenceshidebiggerphotocallout {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDEBIGGERPHOTOCALLOUT" ;;
  }

  dimension: userpreferenceshidechatteronboardingsplash {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDECHATTERONBOARDINGSPLASH" ;;
  }

  dimension: userpreferenceshidecsndesktoptask {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDECSNDESKTOPTASK" ;;
  }

  dimension: userpreferenceshidecsngetchattermobiletask {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDECSNGETCHATTERMOBILETASK" ;;
  }

  dimension: userpreferenceshideenduseronboardingassistantmodal {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDEENDUSERONBOARDINGASSISTANTMODAL" ;;
  }

  dimension: userpreferenceshidelightningmigrationmodal {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDELIGHTNINGMIGRATIONMODAL" ;;
  }

  dimension: userpreferenceshides1_browserui {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDES1BROWSERUI" ;;
  }

  dimension: userpreferenceshidesecondchatteronboardingsplash {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDESECONDCHATTERONBOARDINGSPLASH" ;;
  }

  dimension: userpreferenceshidesfxwelcomemat {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESHIDESFXWELCOMEMAT" ;;
  }

  dimension: userpreferenceslightningexperiencepreferred {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESLIGHTNINGEXPERIENCEPREFERRED" ;;
  }

  dimension: userpreferencespathassistantcollapsed {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESPATHASSISTANTCOLLAPSED" ;;
  }

  dimension: userpreferencespreviewlightning {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESPREVIEWLIGHTNING" ;;
  }

  dimension: userpreferencesrecordhomereservedwtshown {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESRECORDHOMERESERVEDWTSHOWN" ;;
  }

  dimension: userpreferencesrecordhomesectioncollapsewtshown {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESRECORDHOMESECTIONCOLLAPSEWTSHOWN" ;;
  }

  dimension: userpreferencesremindersoundoff {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESREMINDERSOUNDOFF" ;;
  }

  dimension: userpreferencesshowcitytoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWCITYTOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowcitytoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWCITYTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowcountrytoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWCOUNTRYTOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowcountrytoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWCOUNTRYTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowemailtoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWEMAILTOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowemailtoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWEMAILTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowfaxtoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWFAXTOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowfaxtoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWFAXTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowmanagertoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWMANAGERTOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowmanagertoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWMANAGERTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowmobilephonetoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWMOBILEPHONETOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowmobilephonetoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWMOBILEPHONETOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowpostalcodetoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWPOSTALCODETOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowpostalcodetoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWPOSTALCODETOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowprofilepictoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWPROFILEPICTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowstatetoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWSTATETOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowstatetoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWSTATETOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowstreetaddresstoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWSTREETADDRESSTOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowstreetaddresstoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWSTREETADDRESSTOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowtitletoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWTITLETOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowtitletoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWTITLETOGUESTUSERS" ;;
  }

  dimension: userpreferencesshowworkphonetoexternalusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWWORKPHONETOEXTERNALUSERS" ;;
  }

  dimension: userpreferencesshowworkphonetoguestusers {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSHOWWORKPHONETOGUESTUSERS" ;;
  }

  dimension: userpreferencessortfeedbycomment {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESSORTFEEDBYCOMMENT" ;;
  }

  dimension: userpreferencestaskreminderscheckboxdefault {
    type: yesno
    sql: ${TABLE}."USERPREFERENCESTASKREMINDERSCHECKBOXDEFAULT" ;;
  }

  dimension: userroleid {
    type: string
    sql: ${TABLE}."USERROLEID" ;;
  }

  dimension: usertype {
    type: string
    sql: ${TABLE}."USERTYPE" ;;
  }

  measure: count {
    type: count
    drill_fields: [detail*]
  }

  # ----- Sets of fields for drilling ------
  set: detail {
    fields: [
      id,
      communitynickname,
      companyname,
      firstname,
      lastname,
      middlename,
      name,
      username
    ]
  }
}
