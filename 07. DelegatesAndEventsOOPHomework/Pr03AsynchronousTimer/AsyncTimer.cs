﻿using System;
using System.Threading;

namespace Pr03AsynchronousTimer
{
    public class AsyncTimer
    {
        private readonly Action<string> actionMethod;
        private readonly int interval;
        private int ticks;

        public AsyncTimer(Action<string> actionMethod, int interval, int ticks)
        {
            this.ticks = ticks;
            this.interval = interval;
            this.actionMethod = actionMethod;
        }

        private void DoSmth()
        {
            while (this.ticks > 0)
            {
                Thread.Sleep(this.interval);

                if (actionMethod != null)
                {
                    actionMethod(this.ticks.ToString());
                }

                this.ticks--;
            }
        }

        public void Start()
        {
            Thread thread = new Thread(this.DoSmth);
            thread.Start();
        }
    }
}
