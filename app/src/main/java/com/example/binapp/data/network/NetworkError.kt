package com.example.binapp.data.network

enum class NetworkError(val code: Int) {
    BadRequest(400),
    Unauthorized(401),
    PaymentRequired(402),
    Forbidden(403),
    NotFound(404),
    TooManyRequests(429),
    InternalServer(500),
    BadGateway(502),
    ServiceUnavailable(503),
    Unknown(-100),
    NoInternet(-1);

    companion object {
        fun fromCode(code: Int): NetworkError {
            return entries.find { it.code == code } ?: Unknown
        }
    }
}