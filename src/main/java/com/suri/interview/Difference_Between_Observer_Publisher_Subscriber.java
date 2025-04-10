package com.suri.interview;


/**
 Question: what is the difference between pulisher/subscriber and observer design pattern

 Both Publisher/Subscriber (Pub/Sub) and Observer patterns deal with event-driven communication but have key differences in structure, scalability, and decoupling.

 1. Observer Pattern
 Concept:
 One-to-Many Dependency: When one object (Subject) changes state, it notifies all its directly attached Observers.
 Tightly Coupled: The Subject maintains a list of Observers and directly notifies them.
 Synchronous Communication: The notification is often immediate.

 Characteristics:
 ✅ Tightly Coupled: The Subject knows about its Observers.
 ✅ Synchronous Updates: Notifications are sent immediately.
 ✅ Best for Single Process Communication (e.g., UI event handling).


 2. Publisher/Subscriber (Pub/Sub) Pattern
 Concept:
 Message Broker Mediated Communication: Publishers do not know the subscribers.
 Loosely Coupled: The communication happens via a message broker (e.g., Kafka, RabbitMQ).
 Asynchronous Communication: Subscribers receive messages when available.

 Characteristics:
 ✅ Loosely Coupled: Publishers don’t need to know Subscribers.
 ✅ Asynchronous Processing: Messages can be processed later.
 ✅ Best for Distributed Systems (e.g., event-driven microservices).


 When to Use Which?
 Use Observer Pattern → When you need real-time updates in a single application (e.g., UI notifications, stock price updates).
 Use Pub/Sub Pattern → When building scalable event-driven systems (e.g., log processing, microservices communication).
 */

public class Difference_Between_Observer_Publisher_Subscriber {
}
