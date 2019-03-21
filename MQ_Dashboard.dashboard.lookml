- dashboard: salesforce_data_test
  title: Salesforce Data LookML
  layout: newspaper
  elements:
  - title: Accounts Initiated per Leads
    name: Accounts Initiated per Leads
    model: snowflake_salesforce_hemanth
    explore: account
    type: looker_column
    fields:
    - opportunity.leadsource
    - account.count
    filters:
      opportunity.leadsource: "-EMPTY,---None--"
    sorts:
    - account.count desc
    limit: 500
    stacking: ''
    color_application:
      collection_id: b43731d5-dc87-4a8e-b807-635bef3948e7
      palette_id: fb7bb53e-b77b-4ab6-8274-9d420d3d73f3
      options:
        steps: 5
    show_value_labels: true
    label_density: 25
    legend_position: center
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: false
    point_style: none
    series_colors: {}
    series_types: {}
    limit_displayed_rows: false
    y_axes:
    - label: No. of Leads Generated
      orientation: left
      series:
      - id: account.count
        name: Account Count
        axisId: account.count
      showLabels: true
      showValues: true
      unpinAxis: false
      tickDensity: default
      tickDensityCustom: 5
      type: linear
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    x_axis_label: LeadSource
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    ordering: none
    show_null_labels: false
    show_totals_labels: false
    show_silhouette: false
    totals_color: "#808080"
    value_labels: labels
    label_type: labPer
    listen: {}
    row: 10
    col: 12
    width: 12
    height: 8
  - title: Revenue Generated per Technology and Business Usage
    name: Revenue Generated per Technology and Business Usage
    model: snowflake_salesforce_hemanth
    explore: account
    type: looker_column
    fields:
    - opportunity.sf_technology_platform__c
    - opportunity.sum_expectedrevenue
    - opportunity.type
    pivots:
    - opportunity.type
    filters:
      opportunity.sf_technology_platform__c: "-EMPTY"
      opportunity.type: "-EMPTY"
    sorts:
    - opportunity.sf_technology_platform__c
    - opportunity.type
    limit: 500
    trellis: ''
    stacking: percent
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    show_value_labels: true
    label_density: 25
    legend_position: center
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: true
    point_style: none
    series_colors: {}
    series_types: {}
    limit_displayed_rows: false
    limit_displayed_rows_values:
      show_hide: hide
      first_last: first
      num_rows: 0
    y_axes:
    - label: Revenue Generated
      orientation: left
      series:
      - id: Existing Business - opportunity.sum_expectedrevenue
        name: Existing Business
        axisId: Existing Business - opportunity.sum_expectedrevenue
      - id: New Business - opportunity.sum_expectedrevenue
        name: New Business
        axisId: New Business - opportunity.sum_expectedrevenue
      showLabels: true
      showValues: true
      unpinAxis: false
      tickDensity: default
      tickDensityCustom: 5
      type: linear
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    x_axis_label: Technology Platform
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    ordering: none
    show_null_labels: false
    show_totals_labels: false
    show_silhouette: false
    totals_color: "#808080"
    listen: {}
    row: 18
    col: 12
    width: 12
    height: 7
  - title: Estimated Sales
    name: Estimated Sales
    model: snowflake_salesforce_hemanth
    explore: lead
    type: looker_line
    fields:
    - opportunity.fiscal
    - opportunity.sum_expectedrevenue
    filters:
      opportunity.fiscal: "-EMPTY"
    sorts:
    - opportunity.fiscal
    limit: 500
    trellis: ''
    stacking: ''
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    show_value_labels: true
    label_density: 25
    legend_position: center
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: true
    point_style: circle
    series_colors: {}
    series_types:
      opportunity.sum_expectedrevenue: area
    series_point_styles:
      opportunity.sum_expectedrevenue: diamond
    limit_displayed_rows: false
    y_axes:
    - label: Estimated Sale
      orientation: left
      series:
      - id: opportunity.sum_expectedrevenue
        name: Opportunity aNN_rEVENURE
        axisId: opportunity.sum_expectedrevenue
      showLabels: true
      showValues: true
      unpinAxis: false
      tickDensity: default
      tickDensityCustom: 5
      type: linear
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    x_axis_label: Fiscal
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    show_null_points: true
    interpolation: linear
    listen: {}
    row: 31
    col: 13
    width: 11
    height: 8
  - title: Probability of winning an Opportunity per LeadSource
    name: Probability of winning an Opportunity per LeadSource
    model: snowflake_salesforce_hemanth
    explore: account
    type: looker_column
    fields:
    - opportunity.probability
    - opportunity.leadsource
    - opportunity.count
    pivots:
    - opportunity.probability
    filters:
      opportunity.probability: '0,25,50,75,100'
      opportunity.leadsource: "-EMPTY,---None--"
    sorts:
    - opportunity.probability
    - opportunity.count desc 0
    limit: 500
    trellis: ''
    stacking: percent
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    show_value_labels: true
    label_density: 25
    legend_position: center
    hide_legend: false
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: true
    point_style: none
    series_colors: {}
    series_labels:
      25.0 - opportunity.count: 25%
      0.0 - opportunity.count: 0%
      50.0 - opportunity.count: 50%
      75.0 - opportunity.count: 75%
      100.0 - opportunity.count: 100%
    limit_displayed_rows: false
    y_axes:
    - label: Probability of Conversion
      orientation: left
      series:
      - id: 0.0 - opportunity.count
        name: '0'
        axisId: 0.0 - opportunity.count
      - id: 25.0 - opportunity.count
        name: '25'
        axisId: 25.0 - opportunity.count
      - id: 50.0 - opportunity.count
        name: '50'
        axisId: 50.0 - opportunity.count
      - id: 75.0 - opportunity.count
        name: '75'
        axisId: 75.0 - opportunity.count
      - id: 100.0 - opportunity.count
        name: '100'
        axisId: 100.0 - opportunity.count
      showLabels: true
      showValues: true
      unpinAxis: false
      tickDensity: default
      tickDensityCustom: 5
      type: linear
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    x_axis_label: LeadSource
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    ordering: none
    show_null_labels: false
    show_totals_labels: false
    show_silhouette: false
    totals_color: "#808080"
    series_types: {}
    listen: {}
    row: 4
    col: 0
    width: 12
    height: 8
  - title: Total Active Customers
    name: Total Active Customers
    model: snowflake_salesforce_hemanth
    explore: account
    type: single_value
    fields:
    - opportunity.count_id
    limit: 500
    custom_color_enabled: true
    custom_color: ''
    show_single_value_title: true
    single_value_title: Total Active Customers
    show_comparison: false
    comparison_type: value
    comparison_reverse_colors: false
    show_comparison_label: true
    series_types: {}
    row: 0
    col: 12
    width: 6
    height: 4
  - title: Revenue Percentage Diff
    name: Revenue Percentage Diff
    model: snowflake_salesforce_hemanth
    explore: account
    type: single_value
    fields:
    - opportunity.sum_expectedrevenue
    - opportunity.fiscalyear
    filters:
      opportunity.fiscalyear: '2017,2016'
    sorts:
    - opportunity.sum_expectedrevenue desc
    limit: 500
    dynamic_fields:
    - table_calculation: percentage
      label: Percentage
      expression: sum(${opportunity.sum_expectedrevenue})/offset(${opportunity.sum_expectedrevenue},1)-1
      value_format:
      value_format_name: percent_0
      _kind_hint: measure
      _type_hint: number
    custom_color_enabled: true
    custom_color: ''
    show_single_value_title: true
    single_value_title: Revenue Current Year
    value_format: $0.000,, " M"
    show_comparison: true
    comparison_type: change
    comparison_reverse_colors: false
    show_comparison_label: true
    comparison_label: Vs Last Year Revenue
    series_types: {}
    row: 0
    col: 18
    width: 6
    height: 4
  - title: Revenue Generated Vs State
    name: Revenue Generated Vs State
    model: snowflake_salesforce_hemanth
    explore: lead
    type: looker_map
    fields:
    - account.billingstate
    - account.annual_revenue
    filters:
      account.annual_revenue: not 0
      account.billingcountry: United States,USA,US,-EMPTY
    sorts:
    - account.annual_revenue desc
    limit: 500
    map_plot_mode: points
    heatmap_gridlines: true
    heatmap_gridlines_empty: true
    heatmap_opacity: 0.5
    show_region_field: true
    draw_map_labels_above_data: true
    map_tile_provider: light
    map_position: fit_data
    map_scale_indicator: metric
    map_pannable: true
    map_zoomable: true
    map_marker_type: circle
    map_marker_icon_name: default
    map_marker_radius_mode: proportional_value
    map_marker_units: meters
    map_marker_proportional_scale_type: linear
    map_marker_color_mode: fixed
    show_view_names: true
    show_legend: true
    quantize_map_value_colors: false
    reverse_map_value_colors: false
    theme: classic
    show_full_field_name: false
    stacking: normal
    show_value_labels: false
    label_density: 25
    legend_position: center
    x_axis_gridlines: false
    y_axis_gridlines: true
    point_style: none
    series_types: {}
    limit_displayed_rows: false
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    ordering: none
    show_null_labels: false
    show_totals_labels: false
    show_silhouette: false
    totals_color: "#808080"
    listen: {}
    row: 4
    col: 12
    width: 12
    height: 6

  - title: New Tile
    name: New Tile
    model: snowflake_salesforce_hemanth
    explore: account
    type: single_value
    fields:
    - account.billingstate
    - opportunity.sum_expectedrevenue
    filters:
      account.billingstate: "-PA,-EMPTY"
    sorts:
    - opportunity.sum_expectedrevenue desc
    limit: 500
    dynamic_fields:
    - table_calculation: calculation_1
      label: Calculation 1
      expression: rank(${opportunity.sum_expectedrevenue},${opportunity.sum_expectedrevenue})=2
      value_format:
      value_format_name:
      _kind_hint: measure
      _type_hint: yesno
    custom_color_enabled: true
    custom_color: ''
    show_single_value_title: true
    single_value_title: New York
    value_format: $0.000,, " M"
    show_comparison: false
    comparison_type: value
    comparison_reverse_colors: false
    show_comparison_label: true
    series_types: {}
    row: 2
    col: 4
    width: 4
    height: 2
  - title: Accounts Converted per Leads
    name: Accounts Converted per Leads
    model: snowflake_salesforce_hemanth
    explore: account
    type: looker_pie
    fields:
    - account.accountsource
    - opportunity.count
    filters:
      account.accountsource: "-Tools - Rainking,-CRM,-Pardot,-Conference,-AdWords,-Other,-https://www.trianz.com/contact-us,-Events,-EMPTY"
    sorts:
    - opportunity.count desc
    limit: 500
    value_labels: labels
    label_type: labPer
    inner_radius: 70
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    series_colors: {}
    series_types: {}
    listen: {}
    row: 12
    col: 0
    width: 12
    height: 7
  - title: Revenue (>Half Million) Distribution
    name: Revenue (>Half Million) Distribution
    model: snowflake_salesforce_hemanth
    explore: account
    type: looker_pie
    fields:
    - opportunity.sum_expectedrevenue
    - contact.title
    filters:
      opportunity.sum_expectedrevenue: ">1500000"
      contact.title: "-EMPTY"
    sorts:
    - opportunity.sum_expectedrevenue desc
    limit: 500
    value_labels: labels
    label_type: labPer
    inner_radius: 70
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    series_colors: {}
    stacking: ''
    show_value_labels: false
    label_density: 25
    legend_position: center
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: true
    point_style: none
    series_types: {}
    limit_displayed_rows: false
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: false
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    show_null_points: true
    interpolation: linear
    show_totals_labels: false
    show_silhouette: false
    totals_color: "#808080"
    listen: {}
    row: 25
    col: 9
    width: 15
    height: 6
  - title: Gender Split
    name: Gender Split
    model: snowflake_salesforce_hemanth
    explore: lead
    type: looker_pie
    fields:
    - contact.count
    - contact.salutation
    filters:
      contact.salutation: "-Mr,-EMPTY,-Dr."
    sorts:
    - contact.count desc
    limit: 500
    value_labels: labels
    label_type: labPer
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    series_colors: {}
    series_labels:
      Mr.: Men
      Ms.: Women
    series_types: {}
    listen: {}
    row: 19
    col: 0
    width: 12
    height: 6
  - title: User Distribution
    name: User Distribution
    model: snowflake_salesforce_hemanth
    explore: lead
    type: looker_column
    fields:
    - account.billingcountry
    - account.cou_id
    filters:
      account.billingcountry: "-60602,-EMPTY,-Inida,-INDIA"
    sorts:
    - account.cou_id desc
    limit: 500
    trellis: ''
    stacking: normal
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    show_value_labels: false
    label_density: 25
    legend_position: center
    hide_legend: true
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: true
    point_style: circle
    series_colors: {}
    series_types: {}
    limit_displayed_rows: true
    limit_displayed_rows_values:
      show_hide: hide
      first_last: first
      num_rows: 0
    y_axes:
    - label: ''
      orientation: left
      series:
      - id: account.cou_id
        name: Account Cou ID
        axisId: account.cou_id
      showLabels: false
      showValues: false
      unpinAxis: false
      tickDensity: default
      tickDensityCustom: 5
      type: linear
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    x_axis_label: Country
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    ordering: none
    show_null_labels: false
    show_totals_labels: true
    show_silhouette: false
    totals_color: "#808080"
    listen: {}
    row: 25
    col: 0
    width: 9
    height: 6
  - title: Accounts Closed per LeadSource vs Fiscal
    name: Accounts Closed per LeadSource vs Fiscal
    model: snowflake_salesforce_hemanth
    explore: account
    type: looker_column
    fields:
    - opportunity.leadsource
    - opportunity.count
    - opportunity.fiscalyear
    pivots:
    - opportunity.leadsource
    filters:
      opportunity.leadsource: "---None--,-Other,-EMPTY"
      opportunity.fiscal: "-2013 2"
    sorts:
    - opportunity.leadsource 0
    - opportunity.fiscalyear
    limit: 500
    trellis: ''
    stacking: percent
    color_application:
      collection_id: legacy
      palette_id: looker_classic
      options:
        steps: 5
    show_value_labels: true
    label_density: 25
    legend_position: center
    x_axis_gridlines: false
    y_axis_gridlines: true
    show_view_names: true
    point_style: circle
    series_colors: {}
    series_labels:
      opportunity.leadsource: LeadSource
    series_types: {}
    series_point_styles:
      opportunity.leadsource: diamond
    limit_displayed_rows: false
    y_axes:
    - label: Number of Opportunities Generated
      orientation: left
      series:
      - id: Campaign - opportunity.count
        name: Campaign
        axisId: Campaign - opportunity.count
      - id: Cold Call - opportunity.count
        name: Cold Call
        axisId: Cold Call - opportunity.count
      - id: Conference - opportunity.count
        name: Conference
        axisId: Conference - opportunity.count
      - id: Employee - opportunity.count
        name: Employee
        axisId: Employee - opportunity.count
      - id: Events - opportunity.count
        name: Events
        axisId: Events - opportunity.count
      - id: Exisiting Client - opportunity.count
        name: Exisiting Client
        axisId: Exisiting Client - opportunity.count
      - id: Existing Client - opportunity.count
        name: Existing Client
        axisId: Existing Client - opportunity.count
      - id: Inside Sales - opportunity.count
        name: Inside Sales
        axisId: Inside Sales - opportunity.count
      - id: Inside Sales - BCI - opportunity.count
        name: Inside Sales - BCI
        axisId: Inside Sales - BCI - opportunity.count
      - id: Inside Sales - QED - opportunity.count
        name: Inside Sales - QED
        axisId: Inside Sales - QED - opportunity.count
      - id: Pardot - opportunity.count
        name: Pardot
        axisId: Pardot - opportunity.count
      - id: Partner - opportunity.count
        name: Partner
        axisId: Partner - opportunity.count
      - id: Roadshow - opportunity.count
        name: Roadshow
        axisId: Roadshow - opportunity.count
      - id: Self Generated - opportunity.count
        name: Self Generated
        axisId: Self Generated - opportunity.count
      - id: Social Media - LinkedIn - opportunity.count
        name: Social Media - LinkedIn
        axisId: Social Media - LinkedIn - opportunity.count
      - id: Tools - Sales Navigator - opportunity.count
        name: Tools - Sales Navigator
        axisId: Tools - Sales Navigator - opportunity.count
      - id: Website - opportunity.count
        name: Website
        axisId: Website - opportunity.count
      showLabels: true
      showValues: true
      unpinAxis: false
      tickDensity: default
      tickDensityCustom: 5
      type: linear
    y_axis_combined: true
    show_y_axis_labels: true
    show_y_axis_ticks: true
    y_axis_tick_density: default
    y_axis_tick_density_custom: 5
    show_x_axis_label: true
    x_axis_label: Fiscal
    show_x_axis_ticks: true
    x_axis_scale: auto
    y_axis_scale_mode: linear
    x_axis_reversed: false
    y_axis_reversed: false
    plot_size_by_field: false
    ordering: none
    show_null_labels: false
    show_totals_labels: false
    show_silhouette: false
    totals_color: "#808080"
    swap_axes: false
    show_null_points: false
    interpolation: linear
    listen: {}
    row: 31
    col: 0
    width: 13
    height: 8
  - name: ''
    type: text
    title_text: ''
    body_text: |-
      <font color="teal" size="4" ><b>Top 3 Revenue Generating States</b>

      </font>
    row: 0
    col: 0
    width: 12
    height: 2
  - title: New Tile (copy)
    name: New Tile (copy)
    model: snowflake_salesforce_hemanth
    explore: account
    type: single_value
    fields:
    - account.billingstate
    - opportunity.sum_expectedrevenue
    filters:
      account.billingstate: "-PA,-New York,-EMPTY"
    sorts:
    - opportunity.sum_expectedrevenue desc
    limit: 500
    dynamic_fields:
    - table_calculation: calculation_1
      label: Calculation 1
      expression: rank(${opportunity.sum_expectedrevenue},${opportunity.sum_expectedrevenue})=2
      value_format:
      value_format_name:
      _kind_hint: measure
      _type_hint: yesno
    custom_color_enabled: true
    custom_color: ''
    show_single_value_title: true
    single_value_title: Connecticut
    value_format: $0.000,, " M"
    show_comparison: false
    comparison_type: value
    comparison_reverse_colors: false
    show_comparison_label: true
    series_types: {}
    listen: {}
    row: 2
    col: 8
    width: 4
    height: 2
