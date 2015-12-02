using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Pr03CompanyHierarchy.Enums;
using Pr03CompanyHierarchy.Interfaces;

namespace Pr03CompanyHierarchy.Classes
{
    class Project : IProject
    {
        private string projectName;
        private DateTime projectStartDate;
        private string details;
        private State state;

        public Project(string projectName, DateTime projectStartDate, string details)
        {
            this.ProjectName = projectName;
            this.ProjectStartDate = projectStartDate;
            this.Details = details;

            this.state = State.Open;
        }

        public string ProjectName
        {
            get { return projectName; }
            set
            {
                if (string.IsNullOrEmpty(value))
                {
                    throw new ArgumentNullException("Project Name cannot be null or empty");
                }
                projectName = value;
            }
        }

        public DateTime ProjectStartDate
        {
            get { return projectStartDate; }
            set { projectStartDate = value; }
        }

        public string Details
        {
            get { return details; }
            set { details = value; }
        }

        public State State
        {
            get { return state; }
        }

        public void CloseProject()
        {
            this.state = State.Closed;
        }
    }
}
