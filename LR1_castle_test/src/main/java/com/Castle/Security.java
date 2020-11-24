package com.Castle;

public class Security {
    private Squad squad;
    protected GuardianTower guardianTower;

    public Security(Squad squad, float maxGuardians){
        this.squad = squad;
        guardianTower = new GuardianTower(maxGuardians);
    }
    public Security(float maxGuardians){
        guardianTower = new GuardianTower(maxGuardians);
        this.squad = new Squad(20,"Alpha");
    }

    public Squad getSquad() {
        return squad;
    }
    public GuardianTower getGuardianTower(){
        return guardianTower;
    }

    public float getThrusterQuardingCastle(){
        return guardianTower.maxCount - guardianTower.guardianRemains;
    }

    public void sleepGuardians(float amount){
        if(amount > guardianTower.guardianRemains){
            guardianTower.guardianRemains = 0;
        } else {
            guardianTower.guardianRemains = guardianTower.guardianRemains - amount;
        }
    };
    public String getSquadlInfo(){
        return "The Squad: "  +squad.getsquadName() + ", " + squad.getSquadCount() + " person.";
    }

    protected class GuardianTower{
        private float maxCount;
        private float guardianRemains;

        public GuardianTower(float maxCount){
            this.maxCount = maxCount;
            this.guardianRemains = maxCount;
        }
        public float getmaxCount(){
            return maxCount;
        }
        public void apdateGuardians(){
            guardianRemains = maxCount;
        }
    }
}
