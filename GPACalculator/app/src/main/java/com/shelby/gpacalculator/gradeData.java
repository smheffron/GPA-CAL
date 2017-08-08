package com.shelby.gpacalculator;

public class gradeData
{
    double currentGPA;
    int currentHours;
    int currentClasses;
    course currentSchedule[];
    double newGPA;

    gradeData(double gpa, int hours, int schedule)
    {
        currentGPA = gpa;
        currentHours = hours;
        currentClasses = schedule;
        currentSchedule = new course[6];
        for(int i=0; i<6; i++)
        {
            currentSchedule[i] = new course();
        }
        newGPA = 0;
    }

    void fillCourseArray(int Hours, double Percent, int iteration)
    {
        int hours = Hours;
        double percent = Percent;
        double gradepoint = 0;

            if(percent>=93)
            {
                gradepoint = 4.0;
            }
            else if(percent>=90)
            {
                gradepoint = 3.7;
            }
            else if(percent>=87)
            {
                gradepoint=3.3;
            }
            else if(percent>=83)
            {
                gradepoint=3.0;
            }
            else if(percent>=80)
            {
                gradepoint=2.7;
            }
            else if(percent>=77)
            {
                gradepoint=2.3;
            }
            else if(percent>=73)
            {
                gradepoint=2.0;
            }
            else if(percent>=70)
            {
                gradepoint=1.7;
            }
            else if(percent>=67)
            {
                gradepoint=1.3;
            }
            else if(percent>=65)
            {
                gradepoint=1.0;
            }
            else
            {
                gradepoint=0.0;
            }

            currentSchedule[iteration].gradePoints=gradepoint;
            currentSchedule[iteration].creditHours=hours;

    }

    double calculateGPA()
    {
        double totalGP = currentGPA * currentHours;
        int totalCH = currentHours;
        double newGPA = 0;

        for(int i = 0; i<6; i++)
        {
            totalGP+= (currentSchedule[i].gradePoints * currentSchedule[i].creditHours);
            totalCH+=currentSchedule[i].creditHours;
        }

        newGPA = (double)totalGP/totalCH;

        return newGPA;
    }

}

