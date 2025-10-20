# Queue
This folder contains all front-end pages related to the queue management system in Gradiance.

## Files
- **student_queue.html** – Allows students to join or leave the interview queue, view broadcast messages from instructors, and check their estimated interview time.
- **instructor_queue.html** – Enables instructors to manage the active queue: view the student list, start or stop the queue, and send announcements.

## Purpose
The queue module provides an intuitive and organized interface to manage interview waiting lists and announcements. It supports both student and instructor roles with real-time updates.

## Integration Notes
- These pages will communicate with the back-end queue logic (QueueNode, QueueList).
- Designed to synchronize queue status, estimated wait times, and broadcast updates.
