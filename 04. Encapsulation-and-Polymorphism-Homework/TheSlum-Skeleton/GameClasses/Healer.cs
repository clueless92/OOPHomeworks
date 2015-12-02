namespace TheSlum.GameClasses
{
    using System.Collections.Generic;
    using System.Linq;
    using Interfaces;
    public class Healer : Character, IHeal
    {

        private const int DefaultHealthPoints = 75;
        private const int DefaultDefensePoints = 50;
        private const int DefaultRange = 6;
        private const int DefaultHealingPoints = 60;

        public Healer(string id, int x, int y, Team team)
            : base(id, x, y, DefaultHealthPoints, DefaultDefensePoints, team, DefaultRange)
        {
            this.HealingPoints = DefaultHealingPoints;
        }

        public int HealingPoints { get; set; }

        public override Character GetTarget(IEnumerable<Character> targetsList)
        {
            Character target = targetsList
                .Where(x => x.IsAlive)
                .Where(x => x.Team == this.Team)
                .Where(x => x != this)
                .OrderBy(x => x.HealthPoints)
                .FirstOrDefault();

            return target;
        }

        public override void AddToInventory(Item item)
        {
            this.Inventory.Add(item);
            this.ApplyItemEffects(item);
        }

        public override void RemoveFromInventory(Item item)
        {
            this.Inventory.Remove(item);
            this.RemoveItemEffects(item);
        }

        public override string ToString()
        {
            string info = string.Format("-- {1}, Healing: {0}", this.HealingPoints, base.ToString());
            return info;
        }
    }
}
