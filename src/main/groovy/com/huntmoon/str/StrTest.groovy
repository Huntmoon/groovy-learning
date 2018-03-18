package com.huntmoon.str

/**
 * @auther huntmoon
 * @since 2018/3/18.
 */
class StrTest {
    public static void main(String[] args) {


        def gettags = ("git ls-remote git@192.168.20.10:cts/personal-center.git").execute()
        println gettags.text.readLines()
                .collect {it.split()[1]}.findAll {it.startsWith("refs") && !it.endsWith("{}") && !it.contains("merge-requests")}
                .collect({it.replaceAll("refs/","").replaceAll("heads/","")})
                .unique()

    }
}
