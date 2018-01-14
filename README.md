# 入口

**Entrance.** This project is a solo undertaking to overengineer a non-VPN solution for tunneling under my own firewall in order to access application servers running at home.

## Why not use a VPN?

I don't know; do what you want. For real though, I don't really want yet another VPN to have to connect to, and I also do not want to expose _all_ content on my home network and I wanted a lightweight solution for managing users and groups.

## Why is it so janky?

It turns out that VPNs are a thing for a reason.


## Why Scala?

Why not? I work a lot with Scala for my dayjob, but I've never actually started a greenfield project with it, so I was intrigued to do so. Honestly, as I write this (having barely set up the boilerplate) I yearn for the rapidity that Node development would be offering me right now.

On the other hand, I plan to open source this and use it myself, so I'd prefer to have more confidence in the tests that I will presumably write at some stage than I typically do with Javascript applications.

## I'm still here. How do I use it?

Fuck idk. Just like `sbt run` or something. I'll improve the developer and pioneer experience later. Probably.

This thing literally does nothing right now. Come back later and maybe I'll have worked on it. Alternatively, get in touch and help me out :)

## Typical topology

I'm planning to make this very agnostic of topology, but my vision for a typical use-case would be a single globally accessible gateway in the cloud, and one on more installed behind firewalls, each configured to provide access to applications that run in those locations.