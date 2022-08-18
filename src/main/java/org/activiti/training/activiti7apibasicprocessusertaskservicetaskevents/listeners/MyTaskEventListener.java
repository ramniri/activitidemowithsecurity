/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.training.activiti7apibasicprocessusertaskservicetaskevents.listeners;

import org.activiti.api.model.shared.event.RuntimeEvent;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.runtime.events.*;
import org.activiti.api.task.runtime.events.listener.TaskRuntimeEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyTaskEventListener implements TaskRuntimeEventListener {
    private Logger logger = LoggerFactory.getLogger(MyTaskEventListener.class);

    @Override
    public void onEvent(RuntimeEvent runtimeEvent) {

        if (runtimeEvent instanceof TaskActivatedEvent)
            logger.info("Do something, task is activated: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskAssignedEvent) {
            TaskAssignedEvent taskEvent = (TaskAssignedEvent)runtimeEvent;
            Task task = taskEvent.getEntity();
            logger.info("Do something, task is assigned: " + task.toString());
        } else if (runtimeEvent instanceof TaskCancelledEvent)
            logger.info("Do something, task is cancelled: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskCompletedEvent)
            logger.info("Do something, task is completed: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskCreatedEvent)
            logger.info("Do something, task is created: " + runtimeEvent.toString());
        else if (runtimeEvent instanceof TaskSuspendedEvent)
            logger.info("Do something, task is suspended: " + runtimeEvent.toString());
        else
            logger.info("Unknown event: " + runtimeEvent.toString());

    }
}
