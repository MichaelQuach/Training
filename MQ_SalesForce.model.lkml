connection: "snowflake_salesforce"


# include all the views
include: "*.view"

datagroup: snowflake_salesforce_hemanth_default_datagroup {
  # sql_trigger: SELECT MAX(id) FROM etl_log;;
  max_cache_age: "1 hour"
}

persist_with: snowflake_salesforce_hemanth_default_datagroup


explore: lead {
  label: "All tables to account"
  view_name: account

  join: lead{
    type: full_outer
    relationship: many_to_one
    sql_on: ${lead.id} = ${account.id} ;;
  }

  join: opportunity{
    type: full_outer
    relationship: many_to_one
    sql_on: ${opportunity.id} = ${account.id} ;;
  }

  join: organization{
    type: full_outer
    relationship: many_to_one
    sql_on: ${organization.id} = ${account.id} ;;
  }

  join: user{
    type: full_outer
    relationship: many_to_one
    sql_on: ${user.id} = ${account.id} ;;
  }

  join: contact{
    type: full_outer
    relationship: many_to_one
    sql_on: ${contact.id} = ${account.id} ;;
  }
}

explore: account{
  label: "account, contact and oppurtunity"
  view_name: account

  join: opportunity{
    type: full_outer
    relationship: many_to_one
    sql_on: ${opportunity.accountid} = ${account.id} ;;
  }

  join: contact{
    type: full_outer
    relationship: many_to_one
    sql_on: ${contact.accountid} = ${account.id} ;;
  }
}

explore: contact{
  label: "contact & campaign"
  view_name: contact

  join: campaign{
    type: full_outer
    relationship: many_to_one
    sql_on: ${campaign.id} = ${contact.accountid} ;;
  }
}
