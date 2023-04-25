var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "403",
        "ok": "403",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "40",
        "ok": "40",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "209",
        "ok": "209",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "52",
        "ok": "52",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "31",
        "ok": "31",
        "ko": "-"
    },
    "percentiles1": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "percentiles2": {
        "total": "45",
        "ok": "45",
        "ko": "-"
    },
    "percentiles3": {
        "total": "131",
        "ok": "131",
        "ko": "-"
    },
    "percentiles4": {
        "total": "201",
        "ok": "201",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 403,
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
        "total": "7.327",
        "ok": "7.327",
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
        "total": "272",
        "ok": "272",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "40",
        "ok": "40",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "209",
        "ok": "209",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "56",
        "ok": "56",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "37",
        "ok": "37",
        "ko": "-"
    },
    "percentiles1": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "percentiles2": {
        "total": "45",
        "ok": "45",
        "ko": "-"
    },
    "percentiles3": {
        "total": "136",
        "ok": "136",
        "ko": "-"
    },
    "percentiles4": {
        "total": "203",
        "ok": "203",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 272,
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
        "total": "4.945",
        "ok": "4.945",
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
        "total": "131",
        "ok": "131",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "41",
        "ok": "41",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "63",
        "ok": "63",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "44",
        "ok": "44",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "3",
        "ok": "3",
        "ko": "-"
    },
    "percentiles1": {
        "total": "43",
        "ok": "43",
        "ko": "-"
    },
    "percentiles2": {
        "total": "45",
        "ok": "45",
        "ko": "-"
    },
    "percentiles3": {
        "total": "52",
        "ok": "52",
        "ko": "-"
    },
    "percentiles4": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 131,
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
        "total": "2.382",
        "ok": "2.382",
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
