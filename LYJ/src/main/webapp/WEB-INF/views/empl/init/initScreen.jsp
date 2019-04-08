<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="content-body"><!-- Analytics charts -->
<div class="row">
    <div class="col-lg-12 col-md-12 col-12">
        <div class="card">
            <div class="card-header no-border-bottom">
                <h4 class="card-title">Visitors Overview</h4>
                <a class="heading-elements-toggle"><i class="ft-more-horizontal font-medium-3"></i></a>
                <div class="heading-elements">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" class="btn btn-outline-primary btn-round active">Hourly</button>
                        <button type="button" class="btn btn-outline-primary btn-round">Day</button>
                        <button type="button" class="btn btn-outline-primary btn-round">Month</button>
                    </div>
                </div>
            </div>
            <div class="card-content">
                <div class="card-body">
                    <div class="row my-1">
                        <div class="col-lg-4 col-12 p-1 border-right-blue-grey border-right-lighten-5">
                            <div class="text-center">
                                <h3>15,678</h3>
                                <p class="text-muted">Total Visit <span class="success darken-2"><i class="ft-arrow-up"></i> 4.27%</span></p>
                                <div id="sp-bar-total-cost"></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-12 p-1 border-right-blue-grey border-right-lighten-5">
                            <div class="text-center">
                                <h3>8,630</h3>
                                <p class="text-muted">Unique Visitor <span class="danger darken-2"><i class="ft-arrow-down"></i> 2.30%</span></p>
                                <div id="sp-stacked-bar-total-sales"></div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-12 p-1">
                            <div class="text-center">
                                <h3>32,454</h3>
                                <p class="text-muted">Page Views <span class="success darken-2"><i class="ft-arrow-up"></i> 8.16%</span></p>
                                <div id="sp-tristate-bar-total-revenue"></div>
                            </div>
                        </div>
                    </div>

                    <ul class="list-inline text-center mt-3">
                        <li>
                            <h6><i class="ft-circle danger"></i> Page Views</h6>
                        </li>
                        <li>
                            <h6><i class="ft-circle success pl-1"></i> Total Visit</h6>
                        </li>
                        <li>
                            <h6><i class="ft-circle warning pl-1"></i> Unique Visitor</h6>
                        </li>
                    </ul>
                    <div class="chartjs">
                        <canvas id="visitors-graph"  height="275"></canvas>
<!--                         <canvas id="visitors-graph" height="275" width="63" class="chartjs-render-monitor" style="display: block; width: 63px; height: 275px;"></canvas> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ Analytics charts -->


<!-- Analytics map based session -->
<div class="row">
    <div class="col-12">
        <div class="card box-shadow-0">
            <div class="card-content">
                <div class="row">
                    <div class="col-xl-8 col-lg-12">
                        <div id="world-map-markers" class="height-450"></div>
                    </div>
                    <div class="col-xl-4 col-lg-12">
                        <div class="card-body">
                            <h4 class="card-title py-1 text-center">Visitors Sessions</h4>
                            <div class="row">
                                <div class="col-xl-12 col-lg-6 col-sm-12">
                                    <div class="media">
                                        <div class="media-body">
                                            <span>Sessions by Browser</span>
                                        </div>
                                        <div class="media-right media-top pr-2">
                                            <i class="ft-globe font-large-1"></i>
                                        </div>
                                    </div>
                                    <div id="sessions-browser-donut-chart" class="height-200"></div>
                                </div>
                                <div class="col-xl-12 col-lg-6 col-sm-12">
                                    <div class="sales pr-2 pt-2">
                                        <div class="sales-today mb-2">
                                            <p class="m-0">Today's Visitors <span class="sucess float-right"><i class="ft-arrow-up success"></i> 6.89%</span></p>
                                            <div class="progress mt-1 mb-0" style="height: 7px;">
                                                <div class="progress-bar bg-success" role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="sales-yesterday">
                                            <p class="m-0">Yesterday's Visitors <span class="deep-orange accent-2 float-right"><i class="ft-arrow-down deep-orange accent-3"></i> 4.18%</span></p>
                                            <div class="progress mt-1 mb-0" style="height: 7px;">
                                                <div class="progress-bar bg-warning" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Analytics map based session -->


<!-- Bounce Rate & Mobile Device View -->
<div class="row match-height">
    <div class="col-xl-4 col-lg-12">
        <div class="card">
            <div class="card-content">
                <div class="card-body sales-growth-chart">
                    <div class="chart-title">
                        <h1 class="display-4">32%</h1>
                        <span class="text-muted">Bounce Rate</span>
                    </div>
                    <div id="bounce-rate" class="height-250"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-8 col-lg-12">
        <div class="card">
            <div class="card-content">
                <div class="row">
                    <div class="col-lg-3 col-md-12">
                        <div class="chart-stats text-center my-3">
                            <div class="new-users my-2 overflow-hidden clearfix">
                                <span>New Users</span>
                                <h1 class="display-4">25%</h1>
                            </div>
                            <div class="returning-users my-2 overflow-hidden">
                                <span>Returning Users</span>
                                <h1 class="display-4">159</h1>
                            </div>
                            <div class="page-views my-2 overflow-hidden">
                                <span>Page Views</span>
                                <h1 class="display-4">246</h1>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-12">
                        <div class="card-body">
                            <ul class="list-inline text-center">
                                <li class="mr-1">
                                    <h6><i class="ft-circle amber"></i> <span>iOS</span></h6>
                                </li>
                                <li class="mr-1">
                                    <h6><i class="ft-circle primary"></i> <span>Windows</span></h6>
                                </li>
                                <li class="mr-1">
                                    <h6><i class="ft-circle info"></i> <span>Android</span></h6>
                                </li>
                            </ul>
                            <div class="chartjs">
                                <canvas id="line-stacked-area" height="300" ></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ Bounce Rate & Mobile Device View -->

<!-- Audience by country -->
<div class="row match-height">
    <div class="col-xl-6 col-lg-12">
        <div class="card">
            <div class="card-header no-border">
                <h4 class="card-title">Avg. Session Duration & Pages/Session</h4>
                <a class="heading-elements-toggle"><i class="ft-more-horizontal font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-content">
                <div class="card-body">
                    <ul class="list-inline text-right pr-2">
                        <li>
                            <h6><i class="ft-circle grey lighten-1"></i> Avg. Session Duration </h6>
                        </li>
                        <li>
                            <h6><i class="ft-circle red"></i> Pages/Session</h6>
                        </li>
                    </ul>
                    <div id="area-chart" class="height-250"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-6 col-lg-12">
        <div class="card">
            <div class="card-header no-border">
                <h4 class="card-title">Audience by Country</h4>
                <a class="heading-elements-toggle"><i class="ft-more-horizontal font-medium-3"></i></a>
                <div class="heading-elements">
                    <ul class="list-inline mb-0">
                        <li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="card-content">
                <div id="audience-list-scroll" class="table-responsive height-300 position-relative">
                    <table class="table mb-0">
                        <thead>
                            <tr>
                                <th>Country</th>
                                <th>Session</th>
                                <th>% Session</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><i class="flag-icon flag-icon-gb"></i> United State</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    85%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 85%" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-au"></i> Australia</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    75%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-br"></i> Brazil</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    66%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-gb"></i> Great Britain (UK)</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    58%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 58%" aria-valuenow="58" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-hk"></i> Hong Kong</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    45%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 45%" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-in"></i> India</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    38%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 38%" aria-valuenow="38" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-jp"></i> Japan</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    25%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 25%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-mx"></i> Mexico</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    22%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 22%" aria-valuenow="22" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><i class="flag-icon flag-icon-ma"></i> Morocco</td>
                                <td>18</td>
                                <td class="text-center font-small-2">
                                    18%
                                    <div class="progress mt-1 mb-0" style="height: 7px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 18%" aria-valuenow="18" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ Audience by country -->

<!--  -->
<div class="row match-height">
    <div class="col-xl-4 col-lg-6 col-md-12">
        <div class="row">
            <div class="col-sm-12">
                <div class="card no-border">
                    <div class="card-content">
                        <div class="card-body">
                            <div class="media">
                                <div class="media-body">
                                    <h1 class="display-4">$45,668</h1>
                                    <span class="text-muted">Total Sales</span>
                                </div>
                                <div class="media-right media-middle">
                                    <i class="ft-trending-up font-large-2 grey lighten-3"></i>
                                </div>
                            </div>
                        </div>
                        <div id="sp-line-total-sales"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-content">
                        <div class="card-body">
                            <div class="media">
                                <div class="media-body">
                                    <h3>$45,668</h3>
                                    <span class="text-muted">Total Sales</span>
                                </div>
                                <div class="media-right media-middle">
                                    <div id="sp-bar-total-sales"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-content">
                        <div class="card-body">
                            <div class="media">
                                <div class="media-left media-middle">
                                    <div id="sp-tristate-bar-total-sales"></div>
                                </div>
                                <div class="media-body media-right text-right">
                                    <h3>$45,668</h3>
                                    <span class="text-muted">Total Sales</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-4 col-lg-6 col-md-12">
        <div class="card">
            <div class="card-content">
                <div class="card-body text-center">
                    <div class="card-header mb-2">
                        <span class="deep-orange darken-1">Total Budget</span>
                        <h3 class="font-large-2 grey darken-1 text-bold-200">$24,879</h3>
                    </div>
                    <div class="card-content">
                        <input type="text" value="75" class="knob hide-value responsive angle-offset" data-angleOffset="0" data-thickness=".15" data-linecap="round" data-width="150" data-height="150" data-inputColor="#e1e1e1" data-readOnly="true" data-fgColor="#FF5722" data-knob-icon="ft-trending-up">
                        <ul class="list-inline clearfix mt-2 mb-0">
                            <li class="border-right-grey border-right-lighten-2 pr-2">
                                <h2 class="grey darken-1 text-bold-400">75%</h2>
                                <span class="deep-orange">Completed</span>
                            </li>
                            <li class="pl-2">
                                <h2 class="grey darken-1 text-bold-400">25%</h2>
                                <span class="danger">Remaining</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-4 col-lg-12 col-md-12">
        <div class="card">
            <div class="card-content">
                <div class="card-body sales-growth-chart">
                    <div id="monthly-sales" class="height-300"></div>
                </div>
            </div>
            <div class="card-footer">
                <div class="chart-title my-2 text-center">
                    <span class="text-muted">Total monthly Sales.</span>
                </div>
                <div class="chart-stats text-center">
                    <a href="#" class="btn btn-sm btn-primary mr-1">Statistics <i class="ft-bar-chart"></i></a> <span class="text-muted">for the last year.</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/  -->


<div class="row">
    <div class="col-xl-4 col-lg-6 col-md-12">
        <div class="card no-border box-shadow-0">
            <div class="card-content">
                <div class="weather-date position-relative">
                    <div class="date-info position-absolute bg-amber bg-lighten-1 white mt-3 p-1 text-center">
                        <span class="date block">14</span>
                        <span class="month">Nov</span>
                    </div>
                </div>
                <div class="card-body bg-amber bg-lighten-4">
                    <ul class="list-inline text-right">
                        <li><a data-action="reload"><i class="ft-rotate-cw font-medium-4 amber"></i></a></li>
                    </ul>
                    <div class="animated-weather-icons text-center">
                        <svg version="1.1" id="wind" class="climacon climacon_wind climacon-amber climacon-darken-2 height-200" viewBox="15 15 70 70">
                                <g class="climacon_iconWrap climacon_iconWrap-wind">
                                    <g class="climacon_wrapperComponent climacon_componentWrap-wind">
                                        <path
                                        class="climacon_component climacon_component-stroke climacon_component-wind climacon_component-wind_curl"
                                        d="M65.999,52L65.999,52h-3c-1.104,0-2-0.895-2-1.999c0-1.104,0.896-2,2-2h3c1.104,0,2-0.896,2-1.999c0-1.105-0.896-2-2-2s-2-0.896-2-2s0.896-2,2-2c0.138,0,0.271,0.014,0.401,0.041c3.121,0.211,5.597,2.783,5.597,5.959C71.997,49.314,69.312,52,65.999,52z"/>
                                        <path
                                            class="climacon_component climacon_component-stroke climacon_component-wind"
                                            d="M55.999,48.001h-2h-6.998H34.002c-1.104,0-1.999,0.896-1.999,2c0,1.104,0.895,1.999,1.999,1.999h2h3.999h3h4h3h3.998h2c3.313,0,6,2.688,6,6c0,3.176-2.476,5.748-5.597,5.959C56.271,63.986,56.139,64,55.999,64c-1.104,0-2-0.896-2-2c0-1.105,0.896-2,2-2s2-0.896,2-2s-0.896-2-2-2h-2h-3.998h-3h-4h-3h-3.999h-2c-3.313,0-5.999-2.686-5.999-5.999c0-3.175,2.475-5.747,5.596-5.959c0.131-0.026,0.266-0.04,0.403-0.04l0,0h12.999h6.998h2c1.104,0,2-0.896,2-2s-0.896-2-2-2s-2-0.895-2-2c0-1.104,0.896-2,2-2c0.14,0,0.272,0.015,0.403,0.041c3.121,0.211,5.597,2.783,5.597,5.959C61.999,45.314,59.312,48.001,55.999,48.001z"/>
                                    </g>
                                </g>
                        </svg>
                    </div>
                    <div class="weather-details text-center">
                        <span class="my-2 block amber darken-2">Windy</span>
                        <span class="font-medium-4 text-bold-500 amber darken-4">Beijing, China</span>
                    </div>
                </div>
                <div class="card-footer bg-amber bg-darken-3 py-3 text-center no-border">
                    <div class="row">
                        <div class="col-4 text-center display-table-cell">
                            <i class="ft-wind font-large-1 white lighten-3 valign-middle"></i> <span class="white valign-middle">2MPH</span>
                        </div>
                        <div class="col-4 text-center display-table-cell">
                            <i class="ft-sun font-large-1 white lighten-3 valign-middle"></i> <span class="white valign-middle">2%</span>
                        </div>
                        <div class="col-4 text-center display-table-cell">
                            <i class="ft-thermometer font-large-1 white lighten-3 valign-middle"></i> <span class="white valign-middle">13.0&deg;</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-4 col-lg-6 col-md-12">
        <div class="card profile-card-with-cover">
            <div class="card-content">
                <div class="card-img-top img-fluid bg-cover height-200" style="background: url('../../../app-assets/images/backgrounds/fb.jpg') 0 40%;"></div>
                <div class="card-profile-image">
                    <img src="../../../app-assets/images/portrait/small/avatar-s-9.png" class="rounded-circle img-border box-shadow-1" alt="Card image">
                </div>
                <div class="profile-card-with-cover-content text-center">
                    <div class="card-body">
                        <h4 class="card-title">Philip Garrett</h4>
                        <ul class="list-inline clearfix mt-1">
                            <li class="mr-3"><h2 class="block">500+</h2> Connections</li>
                            <li class="mr-3"><h2 class="block">485</h2> Posts</li>
                            <li><h2 class="block">35</h2> Following</li>
                        </ul>
                    </div>
                    <div class="card-body">
                        <a href="#" class="btn btn-social btn-min-width mr-1 mb-1 btn-facebook"><i class="ft-facebook"></i> Facebook</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-xl-4 col-lg-12 col-md-12">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12">
                <div class="card bg-twitter white">
                    <div class="card-content p-2">
                        <div class="card-body">
                            <div class="text-center mb-1">
                                <i class="ft-twitter font-large-3"></i>
                            </div>
                            <div class="tweet-slider">
                                <ul class="text-center">
                                    <li>Congratulations to Rob Jones in accounting for winning our <span class="yellow">#NFL</span> football pool!</li>
                                    <li>Contests are a great thing to partner on. Partnerships immediately <span class="yellow">#DOUBLE</span> the reach.</li>
                                    <li>Puns, humor, and quotes are great content on <span class="yellow">#Twitter</span>. Find some related to your business.</li>
                                    <li>Are there <span class="yellow">#common-sense</span> facts related to your business? Combine them with a great photo.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12 col-md-12 col-sm-12">
                <div class="card bg-facebook white">
                    <div class="card-content p-2">
                        <div class="card-body">
                            <div class="text-center mb-1">
                                <i class="ft-facebook font-large-3"></i>
                            </div>
                            <div class="fb-post-slider">
                                <ul class="text-center">
                                    <li>Congratulations to Rob Jones in accounting for winning our #NFL football pool!</li>
                                    <li>Contests are a great thing to partner on. Partnerships immediately #DOUBLE the reach.</li>
                                    <li>Puns, humor, and quotes are great content on #Twitter. Find some related to your business.</li>
                                    <li>Are there #common-sense facts related to your business? Combine them with a great photo.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        </div>
      </div>
    </div>
</body>
</html>