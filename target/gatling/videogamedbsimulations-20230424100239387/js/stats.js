var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "222",
        "ok": "222",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "41",
        "ok": "41",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "72",
        "ok": "72",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "42",
        "ok": "42",
        "ko": "-"
    },
    "percentiles1": {
        "total": "42",
        "ok": "42",
        "ko": "-"
    },
    "percentiles2": {
        "total": "129",
        "ok": "129",
        "ko": "-"
    },
    "percentiles3": {
        "total": "135",
        "ok": "135",
        "ko": "-"
    },
    "percentiles4": {
        "total": "140",
        "ok": "140",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 222,
    "percentage": 100
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.529",
        "ok": "6.529",
        "ko": "-"
    }
},
contents: {
"req_get-all-video-g-1e227": {
        type: "REQUEST",
        name: "Get All Video Games",
path: "Get All Video Games",
pathFormatted: "req_get-all-video-g-1e227",
stats: {
    "name": "Get All Video Games",
    "numberOfRequests": {
        "total": "148",
        "ok": "148",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "41",
        "ok": "41",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "87",
        "ok": "87",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "45",
        "ok": "45",
        "ko": "-"
    },
    "percentiles1": {
        "total": "86",
        "ok": "86",
        "ko": "-"
    },
    "percentiles2": {
        "total": "131",
        "ok": "131",
        "ko": "-"
    },
    "percentiles3": {
        "total": "137",
        "ok": "137",
        "ko": "-"
    },
    "percentiles4": {
        "total": "141",
        "ok": "141",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 148,
    "percentage": 100
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4.353",
        "ok": "4.353",
        "ko": "-"
    }
}
    },"req_get-specific-ga-f2d93": {
        type: "REQUEST",
        name: "Get Specific Game",
path: "Get Specific Game",
pathFormatted: "req_get-specific-ga-f2d93",
stats: {
    "name": "Get Specific Game",
    "numberOfRequests": {
        "total": "74",
        "ok": "74",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "41",
        "ok": "41",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "48",
        "ok": "48",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "percentiles1": {
        "total": "42",
        "ok": "42",
        "ko": "-"
    },
    "percentiles2": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "percentiles3": {
        "total": "46",
        "ok": "46",
        "ko": "-"
    },
    "percentiles4": {
        "total": "47",
        "ok": "47",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 74,
    "percentage": 100
},
    "group2": {
    "name": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.176",
        "ok": "2.176",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
